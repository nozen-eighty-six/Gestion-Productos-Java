package pe.BoraBora.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
@RequestMapping("/")
public class AccessController {

	public AccessController() {
	}
	
	//ACCESO DENEGADO
	@GetMapping("/accessDenied")
	public String accessDenied_GET(){		
		return "Access/Denied";
	}
}


