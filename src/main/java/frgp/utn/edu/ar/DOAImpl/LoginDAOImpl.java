package frgp.utn.edu.ar.DOAImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import frgp.utn.edu.ar.DAO.LoginDAO;
import frgp.utn.edu.ar.dominio.Usuario;

@Repository
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void guardarUsuario(Usuario usuario) {
			
			String consultaUsuario = "INSERT INTO USERS VALUES(?,?,?,?,?,?,?,?,?)";
			
			jdbcTemplate.update(consultaUsuario, 
								usuario.getUsername(),
								usuario.getPassword(),
								1,
								usuario.getNombre(),
								usuario.getApellido(),
								usuario.getCorreo(),
								usuario.getTelefono(),
								usuario.getDni(),
								usuario.getNacimiento());
			
			String consultaPermisos = "INSERT INTO authorities VALUES(?,?)";
			
			jdbcTemplate.update(consultaPermisos, usuario.getUsername(), usuario.getRol());
	}

}
