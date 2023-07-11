package frgp.utn.edu.ar.dominio;

import java.sql.Date;

public class Usuario {
	
	private String username;
	private String password;
	private String rol;
	private Boolean enabled;
	private String correo;
	private String telefono;
	private Date nacimiento;
	private String dni;
	private String nombre;
	private String apellido;
	
	public Usuario() {
	}

	@Override
	public String toString() {
		return "Usuario [username=" + username + ", password=" + password + ", rol=" + rol + ", correo="
				+ correo + ", telefono=" + telefono + ", nacimiento=" + nacimiento + ", dni=" + dni + ", nombre="
				+ nombre + ", apellido=" + apellido + "]";
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
}
