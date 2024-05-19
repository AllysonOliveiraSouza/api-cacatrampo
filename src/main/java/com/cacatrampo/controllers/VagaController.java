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

import com.cacatrampo.dto.VagaDTO;
import com.cacatrampo.services.VagaService;

@RestController
@RequestMapping(value="/vagas")
public class VagaController {
	
	@Autowired
	private VagaService vagaService;
	
	@GetMapping
	public List<VagaDTO> listarVagas(){
		return vagaService.listarVagas();
	}
	@PostMapping
	public void adicionarVaga(@RequestBody VagaDTO vaga) {
		vagaService.adicionarVaga(vaga);
	}
	@PutMapping
	public VagaDTO alterarVaga(@RequestBody VagaDTO vaga) {
		return vagaService.alterarVaga(vaga);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<Void> excluirVaga(@PathVariable("id")Long id){
		vagaService.excluirVaga(id);
		return ResponseEntity.ok().build();		
	}
	
	@GetMapping("{id}")
	public VagaDTO buscarPorId(@PathVariable Long id) {
		return vagaService.buscarVagaPorID(id);
	}

}
