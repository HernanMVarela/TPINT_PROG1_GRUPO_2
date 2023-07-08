package frgp.utn.edu.ar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	//Login 
	@GetMapping("/login")
	public String redireccionLogin(){
		return "login";
	}	 
	
}
