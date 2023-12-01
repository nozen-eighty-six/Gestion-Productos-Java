package pe.BoraBora.controller;

import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.BoraBora.entity.Account;
import pe.BoraBora.entity.Carrito;
import pe.BoraBora.entity.Orden;
import pe.BoraBora.service.AccountService;
import pe.BoraBora.service.CarritoService;
import pe.BoraBora.service.OrdenService;
import pe.BoraBora.service.ProductoCarritoService;

@Controller 
@RequestMapping("/compra")
public class CompraController {
	@Autowired
	private OrdenService ordenService;
	@Autowired
	private CarritoService carritoService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private ProductoCarritoService productoCarritoService;
	
	public CompraController() {
	}
	
	@GetMapping("/procesar")
	public String realizarCompra_GET(Model model) {
		Orden ordenModel = new Orden();		
		model.addAttribute("detalle",ordenModel);		
		return "Cliente/realizarCompra";
	}
	
	@PostMapping("/procesar")
	public String realizarCompra_POST(Orden orden, HttpSession session) {
		String nombreUser = (String) session.getAttribute("usuarioIniciado");
    	Account cuenta = accountService.CuentaPorUsuario(nombreUser);
    	Carrito carrito = carritoService.findByAccountId(cuenta.getID());    	
    	
		orden.setTotal(carritoService.pagoFinal(carrito.getCarritoId()));		
		ordenService.insert(orden);		

    	// ELIMINAR PRODUCTOS DEL CARRITO -- EN SIGUIENTE SPRINT MOVER LOS DATOS DE CARRITO A DETALLE DE PEDIDO 
    	carrito.getCarritoProductos().stream().forEach(p -> p.setCantidad(0));
    	carritoService.update(carrito);
    	productoCarritoService.eliminarProdsCero();    	
		return "redirect:/compra/detalles";
	}
	
	@GetMapping("/detalles")
	public String detalle_GET(Map map){			
		map.put("aDetalle",ordenService.findAll());
		
		return "Cliente/detalle";
	}
	
}
