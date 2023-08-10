package com.medvoll.apir.paciente;


import com.medvoll.apir.direccion.DatosDireccion;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarPaciente(@NotNull Long id, @NotNull Integer edad, @NotBlank String tipo_sangre ,@NotBlank String email, @NotNull DatosDireccion direccion ) {

}
