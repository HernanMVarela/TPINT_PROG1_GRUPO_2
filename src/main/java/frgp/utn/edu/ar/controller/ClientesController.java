package frgp.utn.edu.ar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import frgp.utn.edu.ar.dominio.Cliente;
import frgp.utn.edu.ar.negocio.ClienteNegocio;

@Controller
public class ClientesController {

	@Autowired
	private ClienteNegocio clienteNegocio;
	
	@RequestMapping(value = {"/clientes"}, method = {RequestMethod.GET, RequestMethod.POST})
	public String Clientes(Model model) {
		
		List<Cliente> listaClientes = clienteNegocio.obtenerClientes();
	    model.addAttribute("listaClientes", listaClientes);

		return "Clientes";
	}
}
