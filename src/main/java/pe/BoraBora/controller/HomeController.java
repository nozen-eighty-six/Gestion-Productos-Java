package pe.BoraBora.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
@RequestMapping("/")
public class HomeController {	
	public HomeController() {}
	
	@GetMapping("")
	public String main_GET() {
		return "redirect:/home";
	}
	
	@GetMapping("/home")
	public String inicio_GET(){		
		return "Inicio/Home";
	}
}
