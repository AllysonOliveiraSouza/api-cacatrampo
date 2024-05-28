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

import com.cacatrampo.dto.AdministradorDTO;
import com.cacatrampo.services.AdministradorService;

@RestController
@RequestMapping("/adms")
public class AdministradorController {
	@Autowired
	private AdministradorService admService;
	@GetMapping
	public List<AdministradorDTO> listarAdms(){
		return admService.listarAdms();
	}
	@PostMapping
	public void adicionarAdm(@RequestBody AdministradorDTO adm) {
		admService.adicionarAdm(adm);
	}
	@PutMapping
	public AdministradorDTO alterarDadosAdm(@RequestBody AdministradorDTO adm) {
		return admService.alterarDadosAdm(adm);
	}
	@DeleteMapping("{id}")
	public void excluirAdm(@PathVariable Long id) {
		admService.excluirAdm(id);
	}
	@GetMapping("{id}")
	public AdministradorDTO buscarPorID(@PathVariable Long id) {
		return admService.buscarPorID(id);
	}

}
