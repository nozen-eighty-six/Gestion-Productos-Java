package pe.BoraBora.controller;


import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import pe.BoraBora.service.AccountService;
import pe.BoraBora.service.ProductoService;
import pe.BoraBora.service.UploadFileService;
import pe.BoraBora.entity.Producto;

@Controller
@RequestMapping("/producto")
public class ProductoController {    
    @Autowired
    private ProductoService productoService; 
    
    @Autowired
    private UploadFileService upload;
    
    @Autowired
	private AccountService accountService;
    
    //--AGREGAR
    @GetMapping("/agregar")
    public String agregarProducto_GET(Model model, HttpSession session) {    	
    	Producto productoModel = new Producto();
		model.addAttribute("producto",productoModel); 
		
		String nombreUser = (String) session.getAttribute("usuarioIniciado");
		String rol = accountService.obtenerRolPorUsuario(nombreUser);
		model.addAttribute("rolusuario", rol);
		model.addAttribute("nombre", nombreUser);
        return "Producto/Agregar";
    }
    
    @PostMapping("/agregar")
    public String agregarProducto_POST(Producto producto, @RequestParam("img") MultipartFile file) throws IOException{ 
    	
    	//IMAGEN
		if (producto.getProductoId()==null) {
			String nombreImagen= upload.saveImage(file);
			producto.setImagen(nombreImagen);
		}else {			
		}
		
    	productoService.insert(producto);		
		return "redirect:/admin/inventario";
    }
    
    //--EDITAR
    @GetMapping("/editar-{id}")
    public String editarProducto_GET(Model model,@PathVariable Integer id, HttpSession session) {    	
    	Producto productoModel = productoService.findByID(id);
		model.addAttribute("producto",productoModel);
		
		String nombreUser = (String) session.getAttribute("usuarioIniciado");
		String rol = accountService.obtenerRolPorUsuario(nombreUser);
		model.addAttribute("rolusuario", rol);
		model.addAttribute("nombre", nombreUser);
        return "Producto/Editar";
    }
    
    @PostMapping("/editar-{id}")
    public String editarProducto_POST(Producto producto) {    	 	
    	productoService.update(producto);		
		return "redirect:/admin/inventario";
    }
    
    //--ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminar_GET(Model model, @PathVariable Integer id, HttpSession session) {

        Producto productoModel = productoService.findByID(id);       
        if (!productoModel.getImagen().equals("default.jpg")) {
            upload.deleteImage(productoModel.getImagen());}
        model.addAttribute("producto", productoModel);
        
        String nombreUser = (String) session.getAttribute("usuarioIniciado");
		String rol = accountService.obtenerRolPorUsuario(nombreUser);
		model.addAttribute("rolusuario", rol);
		model.addAttribute("nombre", nombreUser);
        return "Producto/Eliminar";
    }

	
	@PostMapping("eliminar/{id}")
	public String eliminar_POST(Producto producto, Model model) {
	
        productoService.delete(producto.getProductoId());
		return "redirect:/admin/inventario";
	}
}