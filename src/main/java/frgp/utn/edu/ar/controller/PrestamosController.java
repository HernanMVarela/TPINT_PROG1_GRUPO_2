package frgp.utn.edu.ar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import frgp.utn.edu.ar.dominio.Prestamo;
import frgp.utn.edu.ar.negocio.PrestamoNegocio;

@Controller
public class PrestamosController {

	@Autowired
	private PrestamoNegocio prestamoNegocio;
	
	@RequestMapping(value = {"/prestamos"}, method = {RequestMethod.GET, RequestMethod.POST})
	public String Prestamos(Model model) {
		
		List<Prestamo> listaPrestamos = prestamoNegocio.obtenerPrestamos();
	    model.addAttribute("listaPrestamos", listaPrestamos);
		
		return "Prestamos";
	}
}
