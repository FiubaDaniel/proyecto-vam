package com.daniel.model;

public class Terminado extends EstadoDeRegistro{
	
	private boolean exito;
	
	public Terminado(){
		this.id = IdEstado.TERMINAR; 
	}

	public boolean isExito() {
		return exito;
	}

	public void setExito(boolean exito) {
		this.exito = exito;
	}

}
