package com.medvoll.apir.controller;


import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.medvoll.apir.medico.DatosActualizarMedico;
import com.medvoll.apir.medico.DatosListadoMedico;
import com.medvoll.apir.medico.DatosRegistroMedico;
import com.medvoll.apir.medico.DatosRespuestaMedico;
import com.medvoll.apir.medico.Medico;
import com.medvoll.apir.medico.MedicoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/medicos")

public class MedicoController {
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	
	@PostMapping
	public ResponseEntity<DatosRespuestaMedico> registrarMedico(@RequestBody @Valid DatosRegistroMedico datosRegistroMedico ) {
		Medico medico = medicoRepository.save(new Medico(datosRegistroMedico));
		DatosRespuestaMedico datosRespuestaMedico = new DatosRespuestaMedico(medico.getNombre(), medico.getTelefono(), medico.getTelefono(), medico.getDocumento());
		URI url = UriComponentsBuilder.fromPath("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
		return ResponseEntity.created(url).body(datosRespuestaMedico);
	}
	
	@GetMapping
	public ResponseEntity<Page<DatosListadoMedico>>listarMedicos(Pageable paginacion ){
		return ResponseEntity.ok(medicoRepository.findAll(paginacion).map(DatosListadoMedico::new));
		//return medicoRepository.findAll(paginacion).map(DatosListadoMedico::new);  		//Retorna TODOS LOS MEDICOS
		//return medicoRepository.findByActivoTrue(paginacion).map(DatosListadoMedico::new);
	}
	
	 @PutMapping
	   @Transactional
	   public ResponseEntity<DatosRespuestaMedico> actualizarMedico(@RequestBody @Valid DatosActualizarMedico datosActualizarMedico) {
	        Medico medico = medicoRepository.getReferenceById(datosActualizarMedico.id());
	        medico.actualizarDatos(datosActualizarMedico);
	        
	        return ResponseEntity.ok(new DatosRespuestaMedico(medico.getNombre(),medico.getEmail(),medico.getTelefono(),medico.getEmail()));
	    }
	 
	// 	DELETE ABSOLUTO 
	 
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Void> eliminarMedico(@PathVariable Long id){
		Medico medico = medicoRepository.getReferenceById(id);
		medicoRepository.delete(medico);
		return ResponseEntity.noContent().build();
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DatosRespuestaMedico> retornarMedico(@PathVariable Long id){
		Medico medico = medicoRepository.getReferenceById(id);
		DatosRespuestaMedico datosRespuestaMedico = new DatosRespuestaMedico(medico.getNombre(), medico.getEmail(), medico.getTelefono(), medico.getDocumento());
		return ResponseEntity.ok(datosRespuestaMedico);
		
		
	}
	 
	 
	 
	 //DELETE LOGICO
	/* @DeleteMapping("/{id}")
	 @Transactional
	 public ResponseEntity eliminarMedico(@PathVariable Long id) {
		 Medico medico = medicoRepository.getReferenceById(id);
		 medico.desactivarMedico();
		 return ResponseEntity.noContent().build();
	 }*/
	 
}
