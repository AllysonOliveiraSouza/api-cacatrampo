package com.cacatrampo.entities;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.cacatrampo.dto.AdministradorDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name="Administrador")
@Entity
public class AdministradorEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private String senha;
	@JsonIgnore
	@OneToMany(mappedBy="administrador")
	private List<VagaEntity>vagas;
	
	public AdministradorEntity(AdministradorDTO administradorDTO) {
		BeanUtils.copyProperties(administradorDTO, this);
	}
	
	public AdministradorEntity() {
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
		AdministradorEntity other = (AdministradorEntity) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
