package com.medvoll.apir.infra.security;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

@Service
public class TokenService {
	
	public String generarJWT() {
		try {
		    Algorithm algorithm = Algorithm.HMAC256("123456");
		    
		    return JWT.create().withIssuer("voll med").withSubject("diego rojas")
		    		.sign(algorithm);
		    
		} catch (JWTVerificationException exception){
		    throw new RuntimeException();
		}
	}
}
 