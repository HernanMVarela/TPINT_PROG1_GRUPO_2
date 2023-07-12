package frgp.utn.edu.ar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import frgp.utn.edu.ar.dominio.Usuario;
import frgp.utn.edu.ar.negocio.UsersNegocio;

@Controller
public class UsuariosController {

	@Autowired
	private UsersNegocio userNegocio;
	
	@RequestMapping(value = {"/usuarios"}, method = {RequestMethod.GET, RequestMethod.POST})
	public String Usuarios(Model model) {
		
		List<Usuario> listaUsuarios = userNegocio.obtenerUsuarios();
	    model.addAttribute("listaUsuarios", listaUsuarios);
		
		return "Usuarios";
	}
}
