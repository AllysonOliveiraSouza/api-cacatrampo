package com.cacatrampo.dto;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.cacatrampo.entities.CandidatoEntity;
import com.cacatrampo.entities.CurriculoEntity;
import com.cacatrampo.entities.VagaEntity;

public class CandidatoDTO {

	private Long id;
	private String nome;
	private String email;
	private String senha;
	private String matricula;
	private String telContato;
	private CurriculoEntity curriculo;
	private List<VagaEntity> vagas;

	public CandidatoDTO() {}

	public CandidatoDTO(CandidatoEntity candidato) {
		BeanUtils.copyProperties(candidato, this);
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getTelContato() {
		return telContato;
	}

	public void setTelContato(String telContato) {
		this.telContato = telContato;
	}

	public CurriculoEntity getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(CurriculoEntity curriculo) {
		this.curriculo = curriculo;
	}

	public List<VagaEntity> getVagas() {
		return vagas;
	}

	public void setVagas(List<VagaEntity> vagas) {
		this.vagas = vagas;
	}
	
	

	@Override
	public String toString() {
		return "CandidatoDTO [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", matricula="
				+ matricula + ", telContato=" + telContato + ", curriculo=" + curriculo + ", vagas=" + vagas + "]";
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
