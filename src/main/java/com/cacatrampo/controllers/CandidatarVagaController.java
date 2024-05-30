package com.cacatrampo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cacatrampo.dto.CandidatarVagaDTO;
import com.cacatrampo.services.CandidatarVagaService;

@RestController
@RequestMapping("/candidatarvaga")
public class CandidatarVagaController {

	@Autowired
	private CandidatarVagaService candidatarVagaService;
	
	@PostMapping
	public void Candidatar(@RequestBody CandidatarVagaDTO candidatarVaga) {
		candidatarVagaService.Candidatar(candidatarVaga.getIdUsuario(), 
				candidatarVaga.getIdVaga());		
	}	

}
