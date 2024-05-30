package com.cacatrampo.services;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class CandidatarVagaService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void Candidatar(Long idCandidato, Long idVaga) {		
		entityManager.createNativeQuery("insert into candidatos_vagas "
				+ "values("+idCandidato+","+idVaga+");").executeUpdate();
	}

}
