package pe.BoraBora.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pe.BoraBora.entity.Account;
import pe.BoraBora.entity.Carrito;
import pe.BoraBora.entity.Producto;
import pe.BoraBora.entity.ProductoCarrito;
import pe.BoraBora.service.AccountService;
import pe.BoraBora.service.CarritoService;
import pe.BoraBora.service.CategoriaService;
import pe.BoraBora.service.ProductoCarritoService;
import pe.BoraBora.service.ProductoService;

@Controller @RequestMapping("/")
public class ClienteController {
	@Autowired
	private ProductoService productoService;	
	@Autowired
	private CategoriaService categoriaService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private CarritoService carritoService;
	@Autowired
	private ProductoCarritoService productoCarritoService;
	
	//LISTAR
	@GetMapping("/catalogo")
	public String home(Model model, HttpSession session) {
		model.addAttribute("categorias", categoriaService.findAll());
		model.addAttribute("productos", productoService.findAll());
		
		String nombreUser = (String) session.getAttribute("usuarioIniciado");
		String rol = accountService.obtenerRolPorUsuario(nombreUser);

    	Account cuenta = accountService.CuentaPorUsuario(nombreUser);
    	Carrito carrito = carritoService.findByAccountId(cuenta.getID());
		
		model.addAttribute("rolusuario", rol);
		model.addAttribute("nombre", nombreUser);
		model.addAttribute("nProductos", carritoService.numeroProductos(carrito.getCarritoId()));
		model.addAttribute("idCarrito", carrito.getCarritoId());
		return "Cliente/Catalogo";
	}
	
	//BUSQUEDAD X CATEGORIA - CATALOGO
	@PostMapping("/catalogobusquedad")
	public String prodxCategoriaCatalogo(@RequestParam(name = "categoriaId", required = false) Integer categoriaId, Model model, HttpSession session) {
	    model.addAttribute("categorias", categoriaService.findAll());

	    if (categoriaId == null) {
	        model.addAttribute("productos", productoService.findAll()); // Obtener todos los productos
	    } else {
	        model.addAttribute("productos", productoService.getProductosPorCategoria(categoriaId));
	    }
		
	    String nombreUser = (String) session.getAttribute("usuarioIniciado");
		String rol = accountService.obtenerRolPorUsuario(nombreUser);

    	Account cuenta = accountService.CuentaPorUsuario(nombreUser);
    	Carrito carrito = carritoService.findByAccountId(cuenta.getID());
    	
		model.addAttribute("rolusuario", rol);
		model.addAttribute("nombre", nombreUser);
		model.addAttribute("nProductos", carritoService.numeroProductos(carrito.getCarritoId()));
		model.addAttribute("idCarrito", carrito.getCarritoId());
	    return "Cliente/Catalogo";
	}
	
	//--VER MAS
	@GetMapping("/producto/{id}")
	public String prodHome_GET(Model model,@PathVariable Integer id, HttpSession session) {
		String nombreUser = (String)session.getAttribute("usuarioIniciado");
		String rol = accountService.obtenerRolPorUsuario(nombreUser);
		
    	Producto productoModel = productoService.findByID(id);
    	Account cuenta = accountService.CuentaPorUsuario(nombreUser);
    	Carrito carrito = carritoService.findByAccountId(cuenta.getID());
    	
		model.addAttribute("producto", productoModel);
		model.addAttribute("nProductos", carritoService.numeroProductos(carrito.getCarritoId()));
		model.addAttribute("idCarrito", carrito.getCarritoId());
		
		model.addAttribute("rolusuario", rol);
		model.addAttribute("nombre", nombreUser);
		return "Cliente/Producto";
	}
	// JavaScript AJAX
	@PostMapping("/AgregarAlCarrito")
	public ResponseEntity<Integer> guardarProducto(@RequestParam("id") Integer productoId, @RequestParam("cant") Integer cantidad, HttpSession session) {		
		String nombreUser = (String)session.getAttribute("usuarioIniciado");		
    	Account cuenta = accountService.CuentaPorUsuario(nombreUser);
    	Carrito carrito = carritoService.findByAccountId(cuenta.getID());
		Producto producto = productoService.findByID(productoId);

		ProductoCarrito carritoProducto = new ProductoCarrito();
		carritoProducto.setCarrito(carrito); carritoProducto.setProducto(producto); carritoProducto.setCantidad(cantidad);
	    if (!productoCarritoService.insert(carritoProducto).equals(0)) {
	    	return ResponseEntity.ok(carritoService.numeroProductos(carrito.getCarritoId()));
	    }return ResponseEntity.ok(0);
	}
	@GetMapping("/MostrarCarrito")
    public ResponseEntity<Map<Integer, List<String>>> mostrarInfoCarrito(@RequestParam("carrito")Integer carritoId, HttpSession session) {
		Map<Integer, List<String>> datos = new HashMap<>();//Nombre, Cantidad, Precio
		Collection<ProductoCarrito> info = productoCarritoService.findPCByCarrito(carritoId);
		
		for (ProductoCarrito pc : info) {
		    Producto producto = pc.getProducto();
		    Integer cantidad = pc.getCantidad();
		    int idp = producto.getProductoId();

			List<String> vals = new ArrayList<>();
			if(datos.containsKey(idp)) {
				vals = datos.get(producto.getProductoId());
				Integer cantidadActual = Integer.parseInt(vals.get(1));
				vals.set(1, String.valueOf(cantidadActual+cantidad));
		        datos.put(producto.getProductoId(), vals); 
			}else {
				vals.add(producto.getDescripcion());// Descripción
				vals.add(cantidad.toString());// Cantidad
				vals.add(producto.getPrecio().toString()); // Precio
				datos.put(producto.getProductoId(), vals);
			}
		}
		return ResponseEntity.ok(datos);
    }
	
	@PostMapping("/ActualizarCarrito")
	public ResponseEntity<Integer> actualizarInfoCarrito(@RequestBody Map<Integer, List<Double>> carritoA, HttpSession session) {
		String nombreUser = (String)session.getAttribute("usuarioIniciado");
    	Account cuenta = accountService.CuentaPorUsuario(nombreUser);
    	Carrito carrito = carritoService.findByAccountId(cuenta.getID());
    	
    	Collection<ProductoCarrito> prodsFinal = new ArrayList<>();
    	for (ProductoCarrito pCarr : carrito.getCarritoProductos()) {
    		Integer cantA = carritoA.get(pCarr.getProducto().getProductoId()).get(0).intValue();
    		pCarr.setCantidad(cantA);
    		if(cantA != 0) {
    			prodsFinal.add(pCarr);				 
			}
		}
    	carrito.setCarritoProductos(prodsFinal);
    	carritoService.update(carrito);
    	productoCarritoService.eliminarProdsCero();
		return ResponseEntity.ok(carritoService.numeroProductos(carrito.getCarritoId()));
	}
	
	@PostMapping("/EliminarDelCarrito")
	public ResponseEntity<Integer> eliminarProductoDelCarrito(@RequestParam("id") Integer productoId, HttpSession session) {
	    String nombreUser = (String)session.getAttribute("usuarioIniciado");
	    Account cuenta = accountService.CuentaPorUsuario(nombreUser);
	    Carrito carrito = carritoService.findByAccountId(cuenta.getID());	    

	    carrito.getCarritoProductos().stream().filter(carritoProd -> carritoProd.getProducto().getProductoId().equals(productoId)).forEach(carritoProd -> carritoProd.setCantidad(0));
	    
    	carritoService.update(carrito);
    	productoCarritoService.eliminarProdsCero();

	    return ResponseEntity.ok(carritoService.numeroProductos(carrito.getCarritoId()));
	}
}