package com.medvoll.apir.medico;

import com.medvoll.apir.direccion.DatosDireccion;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarMedico(@NotNull Long id, String nombre, String documento, DatosDireccion direccion) {

}