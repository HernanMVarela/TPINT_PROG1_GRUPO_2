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
public class HomeController {

	@GetMapping("/home")
	public String Home() {
		
		return "Home";
	}
	
	@GetMapping("/access-denied")
	public String AccesoDenegado() {
		
		return "AccessDenied";
	}
}
