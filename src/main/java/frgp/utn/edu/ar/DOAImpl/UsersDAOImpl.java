package frgp.utn.edu.ar.DOAImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import frgp.utn.edu.ar.DAO.UsersDAO;
import frgp.utn.edu.ar.dominio.Usuario;

@Repository
public class UsersDAOImpl implements UsersDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
    private ApplicationContext context;
	
	public List<Usuario> obtenerUsuarios() {
	    String consultaUsuarios = "SELECT u.username, u.password, a.authority, u.enabled, u.correo, u.telefono, u.nacimiento, u.dni, u.nombre, u.apellido FROM USERS u INNER JOIN authorities a ON u.username = a.username";
	    List<Usuario> usuarios = jdbcTemplate.query(consultaUsuarios, new RowMapper<Usuario>() {
	        @Override
	        public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	
	        	Usuario usuario = context.getBean(Usuario.class);
	        	
	            usuario.setUsername(rs.getString("username"));
	            usuario.setPassword(rs.getString("password"));
	            usuario.setRol(rs.getString("authority"));
	            usuario.setEnabled(rs.getBoolean("enabled"));
	            usuario.setCorreo(rs.getString("correo"));
	            usuario.setTelefono(rs.getString("telefono"));
	            usuario.setNacimiento(rs.getDate("nacimiento"));
	            usuario.setDni(rs.getString("dni"));
	            usuario.setNombre(rs.getString("nombre"));
	            usuario.setApellido(rs.getString("apellido"));
	            return usuario;
	        }
	    });
	    return usuarios;
	}
}
