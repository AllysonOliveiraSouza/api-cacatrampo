package com.cacatrampo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	
	@GetMapping
	public List<CandidatoDTO> listarCandidatos(){
		return candidatoService.listarCandidatos();
	}
	@PostMapping
	public void adicionarCandidato(@RequestBody CandidatoDTO candidato) {
		candidatoService.adicionarCandidato(candidato);
	}
	@PutMapping
	public CandidatoDTO alterarCandidato(@RequestBody CandidatoDTO candidato) {
		return candidatoService.alterarCandidato(candidato);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<Void> excluirCandidato(@PathVariable("id")Long id){
		candidatoService.excluirCandidato(id);
		return ResponseEntity.ok().build();
		
	}

}
