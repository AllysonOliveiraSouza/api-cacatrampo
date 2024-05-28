package com.cacatrampo.dto;

import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.cacatrampo.entities.CandidatoEntity;
import com.cacatrampo.entities.CurriculoEntity;

public class CurriculoDTO {

	private Long id;
	private String conteudo;
	private CandidatoEntity candidato;

	public CurriculoDTO() {
	}

	public CurriculoDTO(CurriculoEntity curriculoEntity) {
		BeanUtils.copyProperties(curriculoEntity, this);
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CurriculoDTO other = (CurriculoDTO) obj;
		return Objects.equals(id, other.id);
	}

}
