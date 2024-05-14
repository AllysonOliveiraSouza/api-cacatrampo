package com.cacatrampo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cacatrampo.dto.CandidatoDTO;
import com.cacatrampo.entities.CandidatoEntity;
import com.cacatrampo.repositories.CandidatoRepository;

@Service
public class CandidatoService {

	@Autowired
	private CandidatoRepository candidatoRepository;

	public List<CandidatoDTO> listarCandidatos() {
		List<CandidatoEntity> listaCandidatos = candidatoRepository.findAll();
		return listaCandidatos.stream().map(CandidatoDTO::new).toList();
	}

	public void adicionarCandidato(CandidatoDTO candidato) {
		CandidatoEntity candidatoEntity = new CandidatoEntity(candidato);
		candidatoRepository.save(candidatoEntity);
	}

	public CandidatoDTO alterarCandidato(CandidatoDTO candidato) {
		CandidatoEntity candidatoEntity = new CandidatoEntity(candidato);
		return new CandidatoDTO(candidatoRepository.save(candidatoEntity));
	}

	public void excluirCandidato(Long id) {
		CandidatoEntity candidatoEntity = candidatoRepository.findById(id).get();
		candidatoRepository.delete(candidatoEntity);
	}
	
	public CandidatoDTO buscarPorID(Long id) {
		return new CandidatoDTO(candidatoRepository.findById(id).get());		
	}

}
