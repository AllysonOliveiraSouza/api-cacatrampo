package com.cacatrampo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cacatrampo.dto.VagaDTO;
import com.cacatrampo.entities.VagaEntity;
import com.cacatrampo.repositories.VagaRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class VagaService {
	@Autowired
	private VagaRepository vagaRepository;
	@PersistenceContext
	private EntityManager em;

	//aoisajdoi
	public List<VagaDTO> listarVagas() {
		List<VagaEntity> listaVagas = vagaRepository.findAll();
		return listaVagas.stream().map(VagaDTO::new).toList();
	}

	public void adicionarVaga(VagaDTO vaga) {
		VagaEntity vagaEntity = new VagaEntity(vaga);
		vagaRepository.save(vagaEntity);
	}

	public VagaDTO alterarVaga(VagaDTO vaga) {
		VagaEntity vagaEntity = new VagaEntity(vaga);
		return new VagaDTO(vagaRepository.save(vagaEntity));
	}

	public void excluirVaga(Long id) {		
		VagaEntity vagaEntity = vagaRepository.findById(id).get();
		vagaRepository.delete(vagaEntity);	
	}

	public VagaDTO buscarVagaPorID(Long id) {
		return new VagaDTO(vagaRepository.findById(id).get());
	}

}
