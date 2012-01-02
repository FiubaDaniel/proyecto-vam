package com.daniel.model;

public class Operadora {

	private String nombre;
	private String apellido;
	private long idDeOperadora;

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

	public long getIdDeOperadora() {
		return idDeOperadora;
	}

	public void setIdDeOperadora(long idDeOperadora) {
		this.idDeOperadora = idDeOperadora;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (int) (idDeOperadora ^ (idDeOperadora >>> 32));
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
		Operadora other = (Operadora) obj;
		if (idDeOperadora != other.idDeOperadora)
			return false;
		return true;
	}

}
