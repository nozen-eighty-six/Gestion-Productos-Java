package pe.BoraBora.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.BoraBora.entity.Producto;
import pe.BoraBora.service.AccountService;
import pe.BoraBora.service.CategoriaService;
import pe.BoraBora.service.ProductoService;



@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private AccountService accountService;
	
	//LISTAR 
	@GetMapping("/catalogo")
	public String home(Model model, HttpSession session) {
		model.addAttribute("categorias", categoriaService.findAll());
		model.addAttribute("productos", productoService.findAll());
		
		String nombreUser = (String) session.getAttribute("usuarioIniciado");
		String rol = accountService.obtenerRolPorUsuario(nombreUser);
		model.addAttribute("rolusuario", rol);
		model.addAttribute("nombre", nombreUser);
		return "Admin/Catalogo";
	}
	
	//BUSQUEDAD X CATEGORIA - CATALOGO
	@PostMapping("/catalogobusquedad")
	public String prodxCategoriaCatalogo(@RequestParam(name = "categoriaId", required = false) Integer categoriaId, Model model, HttpSession session) {
	    model.addAttribute("categorias", categoriaService.findAll());

	    if (categoriaId == null || categoriaId.equals("")) {
	        model.addAttribute("productos", productoService.findAll()); // Obtener todos los productos
	    } else {
	        model.addAttribute("productos", productoService.getProductosPorCategoria(categoriaId));
	    }

	    String nombreUser = (String) session.getAttribute("usuarioIniciado");
		String rol = accountService.obtenerRolPorUsuario(nombreUser);
		model.addAttribute("rolusuario", rol);
		model.addAttribute("nombre", nombreUser);
	    return "Admin/Catalogo";
	}
	
	//--LISTAR
	@GetMapping("/inventario")
	public String show(Model model, HttpSession session) {
		model.addAttribute("categorias", categoriaService.findAll());
		model.addAttribute("productos", productoService.findAll());
		
		String nombreUser = (String) session.getAttribute("usuarioIniciado");
		String rol = accountService.obtenerRolPorUsuario(nombreUser);
		model.addAttribute("rolusuario", rol);
		model.addAttribute("nombre", nombreUser);
		return "Admin/Inventario";
	}
	
	//BUSQUEDAD X CATEGORIA - INVENTARIO
	@PostMapping("/inventariobusquedad")
    public String prodxCategoriaInventario(@RequestParam(name = "categoriaId", required = false) Integer categoriaId, Model model, HttpSession session) {
		model.addAttribute("categorias", categoriaService.findAll());
	    if (categoriaId == null || categoriaId.equals("")) {
	        model.addAttribute("productos", productoService.findAll()); // Obtener todos los productos
	    } else {
	        model.addAttribute("productos", productoService.getProductosPorCategoria(categoriaId));
	    }
	    
	    String nombreUser = (String) session.getAttribute("usuarioIniciado");
		String rol = accountService.obtenerRolPorUsuario(nombreUser);
		model.addAttribute("rolusuario", rol);
		model.addAttribute("nombre", nombreUser);
        return "Admin/Inventario";
    }
	
	//--VER MAS
	@GetMapping("/producto/{id}")
	public String prodHome_GET(Model model,@PathVariable Integer id, HttpSession session) {    	
    	Producto productoModel = productoService.findByID(id);
		model.addAttribute("producto", productoModel);
		
		String nombreUser = (String) session.getAttribute("usuarioIniciado");
		String rol = accountService.obtenerRolPorUsuario(nombreUser);
		model.addAttribute("rolusuario", rol);
		model.addAttribute("nombre", nombreUser);
		return "Admin/Producto";
	}
}











