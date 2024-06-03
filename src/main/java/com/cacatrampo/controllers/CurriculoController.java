package com.cacatrampo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cacatrampo.dto.CurriculoDTO;
import com.cacatrampo.services.CurriculoService;

@RestController
@RequestMapping(value="/curriculos")
public class CurriculoController {
	@Autowired
	private CurriculoService curriculoService;
	
	@GetMapping
	public List<CurriculoDTO> listarCurriculos(){
		return curriculoService.listarCurriculos();		
	}
	
	@PostMapping
	public void adicionarCurriculo(@RequestBody CurriculoDTO curriculo) {
		curriculoService.adicionarCurriculo(curriculo);
	}
	
	@PutMapping
	public CurriculoDTO alterarCurriculo(@RequestBody CurriculoDTO curriculo) {
		return curriculoService.alterarCurriculo(curriculo);
	}
	
	@DeleteMapping("{id}")
	public void excluirCurriculo(@PathVariable Long id) {
		curriculoService.excluirCurriculo(id);
	}
	
	@GetMapping("{id}")
	public CurriculoDTO buscarPorID(@PathVariable Long id) {
		return curriculoService.buscarPorID(id);
	}
	
	@GetMapping("/candidato/{idCandidato}")
	public CurriculoDTO buscarPorIdCandidato(@PathVariable Long idCandidato) {
	return curriculoService.buscarPorIdCandidato(idCandidato);
	}

}
