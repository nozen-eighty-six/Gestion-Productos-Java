package pe.BoraBora.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.BoraBora.entity.Account;
import pe.BoraBora.service.AccountService;

@Controller @RequestMapping("/account")
public class AccountController {
	@Autowired
	private AccountService accountService;	

	public AccountController() {}
	
	//--NEW ACCOUNT
	@GetMapping("/create")
	public String create_GET(Model model){
		Account usuarioModel=new Account();
		model.addAttribute("usuario",usuarioModel);
		return "Account/Create";
	}	
	@PostMapping("/create")
	public String registrar_POST(Account account){
		accountService.insert(account);
		return "redirect:/account/login";
	}
	
	//--LOGIN
	@GetMapping("/login")
	public String login_GET(Model model, Account account) {
		Account usuarioModel = new Account();
		model.addAttribute("usuarioL", usuarioModel);
		return "Account/Login";		
	}
	
	@PostMapping("/login")
	public String login_POST(@ModelAttribute("usuarioL") Account account, HttpSession session) {		
	    if (accountService.iniciarSesion(account.getUsuario(), account.getContrasena())) {
	        session.setAttribute("usuarioIniciado", account.getUsuario());
	        
	        String rol = accountService.obtenerRolPorUsuario(account.getUsuario());
//	        System.out.println(" Rol: " + rol);
	        session.setAttribute("rol", rol);

	        return "redirect:/account/redirectByRole";
	    }

	    return "redirect:/account/login?invalid";		
	}

	@GetMapping("/redirectByRole")
	public String redirectByRole(HttpSession session) {
	    String rol = (String) session.getAttribute("rol");

	    if (rol != null) {
	        if (rol.equals("admin")) {
	            return "redirect:/admin/inventario";
	        } else if (rol.equals("cliente")) {
	            return "redirect:/catalogo"; 
	        }
	    }
	    return "redirect:/home";
	}

	
	//--RESET PASSWORD
	@GetMapping("/reset")
	public String reset_GET(Model model,Account account){
		Account resetModel=new Account();
		model.addAttribute("passreset",resetModel);
		return "Account/ResetPass";
	}
	@PostMapping("/reset")
	public String reset_POST(@ModelAttribute("passreset")Account account, Model model){
		if (!account.getContrasena().equals(account.getConfirmarContrasena())) {
            model.addAttribute("passwordMismatch", true);
            return "Account/ResetPass";
        }
		if(accountService.resetPass(account.getCorreo(),account.getContrasena())){
			return "redirect:/account/login";
		}
		return "redirect:/account/reset?invalid";
	}
	

}
