package frgp.utn.edu.ar.DOAImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import frgp.utn.edu.ar.DAO.PrestamoDAO;
import frgp.utn.edu.ar.dominio.Cliente;
import frgp.utn.edu.ar.dominio.Prestamo;

@Repository
public class PrestamoDAOImpl implements PrestamoDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Prestamo> obtenerPrestamos() {
	    String consultaPrestamos = "SELECT p.numero, p.fecha, p.monto, p.cuotas, c.dni, c.nombre, c.apellido, c.direccion, c.codpostal, "
	    	+ "c.provincia, c.nacionalidad, c.nacimiento, c.correo, c.telefono FROM PRESTAMOS p INNER JOIN CLIENTES c ON c.dni = p.dnicliente";
	    List<Prestamo> prestamos = jdbcTemplate.query(consultaPrestamos, new RowMapper<Prestamo>() {
	        @Override
	        public Prestamo mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	Prestamo prestamo = new Prestamo();
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
	        	
	        	prestamo.setNumero(rs.getInt("numero"));
	        	prestamo.setFecha(rs.getDate("fecha"));
	        	prestamo.setMonto(rs.getFloat("monto"));
	        	prestamo.setCuotas(rs.getInt("cuotas"));
	        	prestamo.setCliente(cliente);
	        	
	            return prestamo;
	        }
	    });
	    return prestamos;
	}
}
