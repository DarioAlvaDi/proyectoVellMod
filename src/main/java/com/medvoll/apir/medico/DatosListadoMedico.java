package com.medvoll.apir.medico;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class DatosListadoMedico {
	Long id;
	String nombre;
	String especialidad;
	String documento;
	String email;

	public DatosListadoMedico(Medico medico) {
		this.id = medico.getId();
		this.nombre = medico.getNombre();
		this.especialidad = medico.getEspecialidad().toString();
		this.documento = medico.getDocumento();
		this.email = medico.getEmail();
	}
}
