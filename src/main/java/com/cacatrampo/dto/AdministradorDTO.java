package com.cacatrampo.dto;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.cacatrampo.entities.AdministradorEntity;
import com.cacatrampo.entities.VagaEntity;

public class AdministradorDTO {
	
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private List<VagaEntity>vagas;	

	
	public AdministradorDTO() {

	}

	public AdministradorDTO(AdministradorEntity administradorEntity) {
		BeanUtils.copyProperties(administradorEntity, this);
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
		AdministradorDTO other = (AdministradorDTO) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
