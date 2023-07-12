package frgp.utn.edu.ar.dominio;

import java.sql.Date;

public class Prestamo {
	
	private int numero;
	private Date fecha;
	private Cliente cliente;
	private float monto;
	private int cuotas;
	
	public Prestamo() {
	}

	@Override
	public String toString() {
		return "Prestamo [numero=" + numero + ", fecha=" + fecha + ", cliente=" + cliente + ", monto=" + monto
				+ ", cuotas=" + cuotas + "]";
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public int getCuotas() {
		return cuotas;
	}

	public void setCuotas(int cuotas) {
		this.cuotas = cuotas;
	}

}
