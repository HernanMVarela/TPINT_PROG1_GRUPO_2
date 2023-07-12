package frgp.utn.edu.ar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
