package com.medvoll.apir.paciente;

import com.medvoll.apir.direccion.DatosDireccion;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroPaciente(@NotBlank String nombre, @NotNull Integer edad, @NotNull float altura, @NotNull float peso,
		@NotBlank String nss, @NotBlank String tipo_sangre, @NotBlank String email, @NotBlank String documento, @NotNull DatosDireccion direccion, @NotBlank String telefono) {

}
