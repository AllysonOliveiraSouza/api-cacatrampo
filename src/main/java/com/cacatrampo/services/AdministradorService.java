package com.cacatrampo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cacatrampo.dto.AdministradorDTO;
import com.cacatrampo.entities.AdministradorEntity;
import com.cacatrampo.repositories.AdministradorRepository;

@Service
public class AdministradorService {
	@Autowired
	private AdministradorRepository administradorRepository;
	
	public List<AdministradorDTO> listarAdms(){
		List<AdministradorEntity> listaAdms = administradorRepository.findAll();		
		return listaAdms.stream().map(AdministradorDTO::new).toList();
	}
	
	public void adicionarAdm(AdministradorDTO adm) {
		AdministradorEntity administradorEntity = new AdministradorEntity(adm);
		administradorRepository.save(administradorEntity);
	}

	public AdministradorDTO alterarDadosAdm(AdministradorDTO adm) {
		AdministradorEntity administradorEntity = new AdministradorEntity(adm);
		return new AdministradorDTO(administradorRepository.save(administradorEntity));
	}

	public void excluirAdm(Long id) {
		AdministradorEntity administradorEntity = administradorRepository.findById(id).get();
		administradorRepository.delete(administradorEntity);
	}
	
	public AdministradorDTO buscarPorID(Long id) {
		return new AdministradorDTO(administradorRepository.findById(id).get());
	}

}
