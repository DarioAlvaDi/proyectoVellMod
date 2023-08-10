package com.medvoll.apir.infra.security;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.medvoll.apir.usuarios.Usuario;

@Service
public class TokenService {
	
	public String generarJWT(Usuario usuario) {
		try {
		    Algorithm algorithm = Algorithm.HMAC256("123456");
		    
		    return JWT.create().withIssuer("voll med").withSubject(usuario.getLogin())
		    		.withClaim("id", usuario.getId())
		    		.withExpiresAt(generarFechaExpiracion())
		    		.sign(algorithm);
		    
		} catch (JWTVerificationException exception){
		    throw new RuntimeException();
		}
	}
	
	private Instant generarFechaExpiracion() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
	}
}
 