package frgp.utn.edu.ar.negocioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.utn.edu.ar.DAO.ClienteDAO;
import frgp.utn.edu.ar.dominio.Cliente;
import frgp.utn.edu.ar.negocio.ClienteNegocio;

@Service
public class ClienteNegocioImpl implements ClienteNegocio{

	@Autowired
	private ClienteDAO clienteDAO;

	@Override
	public List<Cliente> obtenerClientes() {
		return clienteDAO.obtenerClientes();
	}
}
