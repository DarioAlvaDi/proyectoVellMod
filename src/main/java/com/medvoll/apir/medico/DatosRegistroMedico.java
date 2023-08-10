package com.medvoll.apir.medico;

import com.medvoll.apir.direccion.DatosDireccion;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DatosRegistroMedico(@NotBlank String nombre, @NotBlank String email, @NotBlank String telefono, @NotBlank @Pattern(regexp = "\\d{4,6}") String documento, Especialidad especialidad, 
		 @NotNull @Valid DatosDireccion direccion  ) {

}
