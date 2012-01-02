package com.daniel.model;

import java.util.List;

public class Registro {

	private String nombre;
	private String apellido;
	private Long dni;
	private Long CBoperadora;
	private List<EstadoDeRegistro> estados;
	private EstadoDeRegistro estadoActual = null;
	

	public Registro(String nom, String ape, Long doc, Long CB, IdEstado id) {

		nombre = nom;
		apellido = ape;
		dni = doc;
		CBoperadora = CB;
		MaquinaDeEstado.modificarEstado(this, id);
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

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public Long getCBoperadora() {
		return CBoperadora;
	}

	public void setCBoperadora(Long cBoperadora) {
		CBoperadora = cBoperadora;
	}

	public EstadoDeRegistro getEstadoActual() {
		return estadoActual;
	}

	public void setEstadoActual(EstadoDeRegistro estadoActual) {
		this.estadoActual = estadoActual;
	}

	public List<EstadoDeRegistro> getEstados() {
		return estados;
	}
}
