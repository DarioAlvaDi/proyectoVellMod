package com.medvoll.apir.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hola2")


public class helloController {
	
	@GetMapping
	public String holaMundo() {
		return "Hola Mundo";
	}
	
	
	
}
