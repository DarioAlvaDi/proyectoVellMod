package com.medvoll.apir.controller;

import java.awt.print.Pageable;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.EntityReader;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.medvoll.apir.paciente.DatosActualizarPaciente;
import com.medvoll.apir.paciente.DatosListadoPaciente;
import com.medvoll.apir.paciente.DatosRegistroPaciente;
import com.medvoll.apir.paciente.DatosRespuestaPaciente;
import com.medvoll.apir.paciente.Paciente;
import com.medvoll.apir.paciente.PacienteRepository;

import jakarta.persistence.Entity;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/paciente")

public class PacienteController {

	@Autowired
	private PacienteRepository pacienteRepository;
	
	@GetMapping
	
	public ResponseEntity<Page<DatosListadoPaciente>>listarPacientes(org.springframework.data.domain.Pageable paginacion){
		return ResponseEntity.ok(pacienteRepository.findAll(paginacion).map(DatosListadoPaciente :: new));        
	}
	
	/*@PostMapping
	public ResponseEntity<DatosRegistroPaciente>  registrarPaciente(@RequestBody @Valid DatosRegistroPaciente datosRegistroPaciente) {
		Paciente paciente = pacienteRepository.save(new Paciente(datosRegistroPaciente));
		DatosRespuestaPaciente datosRespuestaPaciente = new DatosRespuestaPaciente(paciente.getNombre(),paciente.getEdad(),paciente.getAltura(),paciente.getPeso(),
				paciente.getNss(),paciente.getTipo_sangre(),paciente.getEmail(),paciente.getDocumento());
		URI url = UriComponentsBuilder.fromPath("/pacientes/{nss}").buildAndExpand(datosRegistroPaciente.nss()),toUri();
		return ResponseEntity.created(url).body(DatosRegistroPaciente);
		
	}*/
	
	@PutMapping
	@Transactional
	public ResponseEntity<Void> actualizarPaciente(@RequestBody DatosActualizarPaciente datosActualizarPaciente) {
		Paciente paciente = pacienteRepository.getReferenceById(datosActualizarPaciente.id());
		paciente.actualizarDatos(datosActualizarPaciente);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Void>  elminiarPaciente(@RequestParam Long id) {
		Paciente paciente = pacienteRepository.getReferenceById(id);
		paciente.descactivarPaciente();
		return ResponseEntity.noContent().build();
		
	}
	
	
	
	
	
}
