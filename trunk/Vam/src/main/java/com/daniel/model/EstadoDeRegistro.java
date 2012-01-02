package com.daniel.model;

import com.daniel.util.FechaUtil;

public abstract class EstadoDeRegistro {
	
	protected FechaUtil fechaDeRealizacion;
	protected IdEstado id;

	public IdEstado getIdEstado() {
		return id;
	}

	public FechaUtil getFechaDeRealizacion() {
		return fechaDeRealizacion;
	}

	public void setFechaDeRealizacion(FechaUtil fechaDeRealizacion) {
		this.fechaDeRealizacion = fechaDeRealizacion;
	}
	

}
