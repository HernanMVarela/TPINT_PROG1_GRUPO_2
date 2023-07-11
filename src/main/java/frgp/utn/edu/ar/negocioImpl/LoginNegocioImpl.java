package frgp.utn.edu.ar.negocioImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.utn.edu.ar.DAO.LoginDAO;
import frgp.utn.edu.ar.dominio.Usuario;
import frgp.utn.edu.ar.negocio.LoginNegocio;

@Service
public class LoginNegocioImpl implements LoginNegocio{

	@Autowired
	private LoginDAO loginDAO;
	
	@Override
	public void guardarUsuario(Usuario usuario) {
				
		loginDAO.guardarUsuario(usuario);
	}

}
