package com.cacatrampo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cacatrampo.dto.CandidatoDTO;
import com.cacatrampo.services.CandidatoService;

@RestController
@RequestMapping(value="/candidatos")
public class CandidatoController {
	
	@Autowired
	private CandidatoService candidatoService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping
	public List<CandidatoDTO> listarCandidatos(){
		return candidatoService.listarCandidatos();
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping
	public void adicionarCandidato(@RequestBody CandidatoDTO candidato) {
		candidatoService.adicionarCandidato(candidato);
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping
	public CandidatoDTO alterarCandidato(@RequestBody CandidatoDTO candidato) {
		return candidatoService.alterarCandidato(candidato);
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("{id}")
	public ResponseEntity<Void> excluirCandidato(@PathVariable("id")Long id){
		candidatoService.excluirCandidato(id);
		return ResponseEntity.ok().build();
		
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/{id}")
	public CandidatoDTO buscarPorId(@PathVariable Long id) {
		return candidatoService.buscarPorID(id);		
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping(value="/{idVaga}/{idCandidato}")
	public CandidatoDTO enviarCurriculo(@PathVariable(value="idVaga")Long idVaga, 
			@PathVariable(value="idCandidato")Long idCandidato){
		return candidatoService.enviarCurriculo(idVaga, idCandidato);		
	}

}
