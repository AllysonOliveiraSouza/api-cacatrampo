package com.cacatrampo.entities;

import org.springframework.beans.BeanUtils;

import com.cacatrampo.dto.CurriculoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table(name="Curriculo")
@Entity
public class CurriculoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false,columnDefinition = "TEXT")
	private String conteudo;
	@JsonIgnore
	@OneToOne()
	private CandidatoEntity candidato;
	
	public CurriculoEntity() {}

	public CurriculoEntity(CurriculoDTO curriculoDTO) {
		BeanUtils.copyProperties(curriculoDTO, this);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public CandidatoEntity getCandidato() {
		return candidato;
	}

	public void setCandidato(CandidatoEntity candidato) {
		this.candidato = candidato;
	}
	
	
}
