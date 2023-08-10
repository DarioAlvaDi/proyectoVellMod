package com.medvoll.apir.paciente;


import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class DatosListadoPaciente {
	private String nombre;
	private Integer edad;
	private float peso;
	private String tipo_sangre;
	private String email;
	
	public DatosListadoPaciente(Paciente paciente) {
		this.nombre = paciente.getNombre();
		this.edad = paciente.getEdad();
		this.peso = paciente.getPeso();
		this.tipo_sangre = paciente.getTipo_sangre();
		this.email = paciente.getEmail();
		
	}
	
	
}
