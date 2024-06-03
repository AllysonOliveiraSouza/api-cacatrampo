package com.cacatrampo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cacatrampo.entities.CurriculoEntity;

public interface CurriculoRepository extends JpaRepository<CurriculoEntity, Long>{
	
	CurriculoEntity findByCandidatoId(Long candidatoId);

}
