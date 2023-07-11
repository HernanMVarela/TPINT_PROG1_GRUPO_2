package frgp.utn.edu.ar.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import frgp.utn.edu.ar.dominio.Usuario;
import frgp.utn.edu.ar.negocio.LoginNegocio;

@Controller
public class RegistroController {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private LoginNegocio loginNegocio;
	
	@PostMapping(value = {"/alta_usuario"})
	public String AltaUsuario(Usuario usuario, HttpServletRequest request) {
		String password = request.getParameter("password");
	    String passwordConfirm = request.getParameter("passwordConfirm");
	    
	    if (!password.equals(passwordConfirm)) {
	        return "redirect:/registro?pass=true";
	    }
		String passwordCodificada = passwordEncoder.encode(usuario.getPassword());
		usuario.setPassword(passwordCodificada);
		
		loginNegocio.guardarUsuario(usuario);
		
		return "redirect:/login?newuser";
	}
}
