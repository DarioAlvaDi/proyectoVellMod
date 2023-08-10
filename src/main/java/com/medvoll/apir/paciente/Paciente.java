package com.medvoll.apir.paciente;

import com.medvoll.apir.direccion.DatosDireccion;
import com.medvoll.apir.direccion.Direccion;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")

@Entity(name = "paciente")
@Table(name ="paciente")

public class Paciente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private Integer edad;
	private float altura;
	private float peso;
	private String nss;
	private String tipo_sangre;
	private String email;
	private String documento;
	private String telefono;
	private Boolean activo;
	@Embedded
	Direccion direccion;
	
	public Paciente(DatosRegistroPaciente datosRegistroPaciente) {
		this.nombre = datosRegistroPaciente.nombre();
		this.edad = datosRegistroPaciente.edad();
		this.altura = datosRegistroPaciente.edad();
		this.peso = datosRegistroPaciente.peso();
		this.nss = datosRegistroPaciente.nss();
		this.tipo_sangre = datosRegistroPaciente.tipo_sangre();
		this.email = datosRegistroPaciente.email();
		this.documento = datosRegistroPaciente.documento();
		this.telefono = datosRegistroPaciente.telefono();
		this.direccion = new Direccion(datosRegistroPaciente.direccion());
		this.activo = true;
		
	}
	
	public void actualizarDatos(DatosActualizarPaciente datosActualizarPaciente) {
		if(datosActualizarPaciente.edad() != null) {
			this.edad = datosActualizarPaciente.edad();
		}
		if(datosActualizarPaciente.tipo_sangre() != null) {
			this.tipo_sangre = datosActualizarPaciente.tipo_sangre();
		}
		if(datosActualizarPaciente.email() != null) {
			this.email = datosActualizarPaciente.email();
		}
		if(datosActualizarPaciente.direccion() != null) {
			this.direccion = direccion.actualizarDatos(datosActualizarPaciente.direccion());
		}
	
	}
	
	public void descactivarPaciente() {
		this.activo = false;
	}

		
}
