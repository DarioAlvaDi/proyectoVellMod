package com.medvoll.apir.direccion;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Direccion {
	private String calle;
	private String numero;
	private String complemento;
	private String distrito;
	private String ciudad;
	
	public Direccion(DatosDireccion direccion) {
		this.calle = direccion.calle();
		this.numero = direccion.numero();
		this.complemento = direccion.complemento();
		this.distrito = direccion.distrito();
		this.ciudad = direccion.ciudad();
		
	}
	
	public Direccion actualizaDatosDireccion(DatosDireccion datosDireccion) {
		this.calle = datosDireccion.calle();
		this.numero = datosDireccion.numero();
		this.complemento = datosDireccion.complemento();
		this.distrito = datosDireccion.distrito();
		this.ciudad = datosDireccion.ciudad();
		return this;
	}

	 public Direccion actualizarDatos(DatosDireccion direccion) {
	        this.calle = direccion.calle();
	        this.numero = direccion.numero();
	        this.distrito = direccion.distrito();
	        this.complemento = direccion.complemento();
	        this.ciudad = direccion.ciudad();
	        return this;
	    }
}
