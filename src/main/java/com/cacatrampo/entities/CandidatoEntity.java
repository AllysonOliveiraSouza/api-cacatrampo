package com.cacatrampo.entities;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.cacatrampo.dto.CandidatoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Candidatos")
public class CandidatoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String senha;	
	@Column(name="matricula_ra",nullable=false)
	private String matricula;
	@Column(name="tel_contato",nullable=false)
	private String telContato;
	@JsonIgnore
	@OneToOne(mappedBy="candidato")
	private CurriculoEntity curriculo;
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="candidatos_vagas", joinColumns = @JoinColumn(name="candidato_id"),
	inverseJoinColumns = @JoinColumn(name="vaga_id"))
	private List<VagaEntity> vagas;
	
	public CandidatoEntity() {
	}

	public CandidatoEntity(CandidatoDTO candidato) {
		BeanUtils.copyProperties(candidato, this);
	}
	
	public CurriculoEntity getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(CurriculoEntity curriculo) {
		this.curriculo = curriculo;
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
		CandidatoEntity other = (CandidatoEntity) obj;
		return Objects.equals(id, other.id);
	}

}
