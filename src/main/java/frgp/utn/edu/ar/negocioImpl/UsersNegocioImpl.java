package frgp.utn.edu.ar.negocioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.utn.edu.ar.DAO.UsersDAO;
import frgp.utn.edu.ar.dominio.Usuario;
import frgp.utn.edu.ar.negocio.UsersNegocio;

@Service
public class UsersNegocioImpl implements UsersNegocio{

	@Autowired
	private UsersDAO usersDAO;

	@Override
	public List<Usuario> obtenerUsuarios() {
		return usersDAO.obtenerUsuarios();
	}
}
