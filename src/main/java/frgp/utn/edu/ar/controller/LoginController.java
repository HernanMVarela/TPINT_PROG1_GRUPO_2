package frgp.utn.edu.ar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import frgp.utn.edu.ar.dominio.Usuario;

@Controller
public class LoginController {

	@PostMapping("/loginSuccesful")
	public String login(RedirectAttributes redirectAttributes) {
	    redirectAttributes.addAttribute("loginok", "true");
	    return "redirect:/home";
	}
	
	@GetMapping("/login")
	public String LoginInicial() {
		
		return "login";
	}
	
	@GetMapping("/")
	public String InitialLogin() {
		
		return "login";
	}
	
	@RequestMapping(value = {"/registro"}, method = {RequestMethod.GET, RequestMethod.POST})
	public String Registro(@ModelAttribute("usuario") Usuario usuario) {
		
		return "RegistroUsuario";
	}
	
}
