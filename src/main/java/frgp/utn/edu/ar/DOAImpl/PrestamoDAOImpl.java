package frgp.utn.edu.ar.DOAImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import frgp.utn.edu.ar.DAO.PrestamoDAO;
import frgp.utn.edu.ar.dominio.Prestamo;

@Repository
public class PrestamoDAOImpl implements PrestamoDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
    private ApplicationContext context;
	
	public List<Prestamo> obtenerPrestamos() {
	    String consultaPrestamos = "SELECT p.numero, p.fecha, p.monto, p.cuotas, c.dni, c.nombre, c.apellido, c.direccion, c.codpostal, "
	    	+ "c.provincia, c.nacionalidad, c.nacimiento, c.correo, c.telefono FROM PRESTAMOS p INNER JOIN CLIENTES c ON c.dni = p.dnicliente";
	    List<Prestamo> prestamos = jdbcTemplate.query(consultaPrestamos, new RowMapper<Prestamo>() {
	        @Override
	        public Prestamo mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Prestamo prestamo = context.getBean(Prestamo.class);
	        	
	            prestamo.getCliente().setDni(rs.getString("dni"));
	            prestamo.getCliente().setNombre(rs.getString("nombre"));
	            prestamo.getCliente().setApellido(rs.getString("apellido"));
	            prestamo.getCliente().setDireccion(rs.getString("direccion"));
	            prestamo.getCliente().setCodpostal(rs.getInt("codpostal"));
	            prestamo.getCliente().setProvincia(rs.getString("provincia"));
	        	prestamo.getCliente().setNacionalidad(rs.getString("nacionalidad"));
	        	prestamo.getCliente().setNacimiento(rs.getDate("nacimiento"));
	        	prestamo.getCliente().setCorreo(rs.getString("correo"));
	        	prestamo.getCliente().setTelefono(rs.getString("telefono"));
	        	
	        	prestamo.setNumero(rs.getInt("numero"));
	        	prestamo.setFecha(rs.getDate("fecha"));
	        	prestamo.setMonto(rs.getFloat("monto"));
	        	prestamo.setCuotas(rs.getInt("cuotas"));
	        	
	            return prestamo;
	        }
	    });
	    return prestamos;
	}
}
