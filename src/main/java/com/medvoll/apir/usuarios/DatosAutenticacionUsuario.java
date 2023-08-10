package com.medvoll.apir.usuarios;

import jakarta.validation.constraints.NotBlank;

public record DatosAutenticacionUsuario(@NotBlank String login,@NotBlank String clave) {
	
}
