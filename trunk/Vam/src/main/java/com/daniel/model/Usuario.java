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
	
	public void agregarRegistro(String nombre,String apellido, Long dni, Long CBoperadora, FechaUtil fecha ){
		
		Registro registro = buscarRegistro(dni);
		if(registro == null){
			
		}
		
	}
	
	public Registro buscarRegistro(Long dni){
		
		return null;
	}
	
	public void modificarRegiatro(){
		
	}
	
	public void eliminarRegistro(){
		
		
	}
	

}
