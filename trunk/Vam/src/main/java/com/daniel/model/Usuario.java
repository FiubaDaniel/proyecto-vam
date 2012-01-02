package com.daniel.model;

import com.daniel.util.FechaUtil;

public class Usuario {

	private String nombre;
	private String apellido;
	private Long id;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/*
	 * Devuelve true si el registro no existe y se agrega correctamente.
	 * Devuelve false si el registro existia y no se pudo agregar.
	 */
	public boolean agregarRegistro(String nombre, String apellido, Long dni,
			Long CBoperadora, FechaUtil fecha, IdEstado estado) {

		Registro registro = buscarRegistro(dni);
		if (registro == null) {
			registro = new Registro(nombre, apellido, dni, CBoperadora, estado);
			registro.getEstadoActual().setFechaDeRealizacion(fecha);
			registro.getEstados().add(registro.getEstadoActual());
			return true; //TODO falta modificar en la base de datos.
		} else {
			return false;
		}
	}

	/*
	 * Devuelve null si el registro no existe. Si existe lo devuelve.
	 */
	public Registro buscarRegistro(Long dni) {
		// TODO todavia no determine donde voy a guardar los datos.
		return null;
	}

	/*
	 * Si encuentra el registro y lo puede modificar, lease el nuevo estado es
	 * posible poner devuelve verdadero. Si no lo encuentra o el estado no es
	 * posible de establecer devuelve false y no lo modifica
	 */

	public boolean modificarRegistro(long dni, IdEstado estado, FechaUtil fecha) {
		Registro registro = buscarRegistro(dni);
		if (registro != null) {
			boolean resultado = MaquinaDeEstado.modificarEstado(registro,
					estado);
			if (resultado) {
				registro.getEstadoActual().setFechaDeRealizacion(fecha);
				registro.getEstados().add(registro.getEstadoActual());
			}// TODO falta modificar en la base de datos.
			return resultado;
		}
		return false;

	}

	/*
	 * Tiene la misma funcionalidad que modificar registro pero se utiliz<a para
	 * darle fin a un transaccion, dertminando si fue exitosa o no.
	 */
	public boolean modificarregistroTerminar(long dni, IdEstado estado,
			FechaUtil fecha, boolean exito) {
		Registro registro = buscarRegistro(dni);
		if (registro != null) {
			MaquinaDeEstado.modificarEstado(registro, estado, exito);
			registro.getEstadoActual().setFechaDeRealizacion(fecha);
			registro.getEstados().add(registro.getEstadoActual());
			return true;
		}// TODO falta modificar en la base de datos.
		return false;
	}

	public void eliminarRegistro() {
		// TODO todavia no determine donde voy a guardar los datos.
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
