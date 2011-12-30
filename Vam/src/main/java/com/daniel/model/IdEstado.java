package com.daniel.model;

public enum IdEstado {
	
	FIRMARYRETIRAR("firmaryretirar"),
	
	FIRMAR("firmar"),
	
	RETIRAR("retirar"),
	
	TERMINAR("terminar"),
	
	DEJAR("dejar");
	
	
	private String estado;
	
	private IdEstado(String estado) {
		this.estado = estado;
	}
	

	public String getAtributo() {
		return estado;
	}

}
