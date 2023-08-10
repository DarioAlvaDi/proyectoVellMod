package com.medvoll.apir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;
import com.medvoll.apir.usuarios.DatosAutenticacionUsuario;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/login")

public class AutenticacionController {
	
	@Autowired
	private AuthenticationManager autenticacionManager;
	
	
	@PostMapping
	public ResponseEntity<Void> autenticacionUsuario(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario){
		Authentication token = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.login(),datosAutenticacionUsuario.clave());
		autenticacionManager.authenticate(token);
		return ResponseEntity.ok().build();
	}
}