package com.cacatrampo.dto;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.cacatrampo.entities.CandidatoEntity;
import com.cacatrampo.entities.VagaEntity;

public class CandidatoDTO {

	private Long id;
	private String nome;
	private String login;
	private String senha;
	private List<VagaEntity> vagas;
	
	public CandidatoDTO(CandidatoEntity candidato) {
		BeanUtils.copyProperties(candidato, this);
	}
	
	public CandidatoDTO() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public List<VagaEntity> getVagas() {
		return vagas;
	}

	public void setVagas(List<VagaEntity> vagas) {
		this.vagas = vagas;
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
		CandidatoDTO other = (CandidatoDTO) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
