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

import com.medvoll.apir.infra.security.DatosJWToken;
import com.medvoll.apir.infra.security.TokenService;
import com.medvoll.apir.usuarios.DatosAutenticacionUsuario;
import com.medvoll.apir.usuarios.Usuario;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/login")

public class AutenticacionController {
	
	@Autowired
	private AuthenticationManager autenticacionManager;
	
	@Autowired 
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<DatosJWToken> autenticacionUsuario(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario){
		Authentication token = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.login(),datosAutenticacionUsuario.clave());
		Authentication usuarioAutenticado = autenticacionManager.authenticate(token);
		String JWToken = tokenService.generarJWT((Usuario)usuarioAutenticado.getPrincipal());
		return ResponseEntity.ok(new DatosJWToken (JWToken));
	}
}
