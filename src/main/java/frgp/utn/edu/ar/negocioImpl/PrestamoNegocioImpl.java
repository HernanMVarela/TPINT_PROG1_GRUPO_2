package frgp.utn.edu.ar.negocioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.utn.edu.ar.DAO.PrestamoDAO;
import frgp.utn.edu.ar.dominio.Prestamo;
import frgp.utn.edu.ar.negocio.PrestamoNegocio;

@Service
public class PrestamoNegocioImpl implements PrestamoNegocio{

	@Autowired
	private PrestamoDAO prestamoDAO;

	@Override
	public List<Prestamo> obtenerPrestamos() {
		return prestamoDAO.obtenerPrestamos();
	}
}
