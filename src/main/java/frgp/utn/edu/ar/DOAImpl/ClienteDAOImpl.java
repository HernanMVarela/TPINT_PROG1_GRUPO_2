package frgp.utn.edu.ar.DOAImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import frgp.utn.edu.ar.DAO.ClienteDAO;
import frgp.utn.edu.ar.dominio.Cliente;

@Repository
public class ClienteDAOImpl implements ClienteDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Cliente> obtenerClientes() {
	    String consultaClientes = "SELECT c.dni, c.nombre, c.apellido, c.direccion, c.codpostal, c.provincia, c.nacionalidad, "
	    		+ "c.nacimiento, c.correo, c.telefono FROM CLIENTES c";
	    List<Cliente> clientes = jdbcTemplate.query(consultaClientes, new RowMapper<Cliente>() {
	        @Override
	        public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	Cliente cliente = new Cliente();
	        	cliente.setDni(rs.getString("dni"));
	        	cliente.setNombre(rs.getString("nombre"));
	        	cliente.setApellido(rs.getString("apellido"));
	        	cliente.setDireccion(rs.getString("direccion"));
	        	cliente.setCodpostal(rs.getInt("codpostal"));
	        	cliente.setProvincia(rs.getString("provincia"));
	        	cliente.setNacionalidad(rs.getString("nacionalidad"));
	        	cliente.setNacimiento(rs.getDate("nacimiento"));
	        	cliente.setCorreo(rs.getString("correo"));
	        	cliente.setTelefono(rs.getString("telefono"));
	            return cliente;
	        }
	    });
	    return clientes;
	}
}
