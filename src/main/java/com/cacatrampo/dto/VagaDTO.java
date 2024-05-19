package com.cacatrampo.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.cacatrampo.entities.CandidatoEntity;
import com.cacatrampo.entities.VagaEntity;



public class VagaDTO {
	
	private Long id;
	private String titulo;
	private LocalDate dataPostagem;
	private Double salario;
	private String tipoContratacao;
	private String modeloTrabalho;
	private String local;
	private String nomeEmpresa;
	private String descricaoVaga;
	private List<CandidatoEntity> candidatos;


	public VagaDTO(VagaEntity vaga) {
		BeanUtils.copyProperties(vaga, this);
	}
	
	public VagaDTO() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getDataPostagem() {
		return dataPostagem;
	}

	public void setDataPostagem(LocalDate dataPostagem) {
		this.dataPostagem = dataPostagem;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getTipoContratacao() {
		return tipoContratacao;
	}

	public void setTipoContratacao(String tipoContratacao) {
		this.tipoContratacao = tipoContratacao;
	}

	public String getModeloTrabalho() {
		return modeloTrabalho;
	}

	public void setModeloTrabalho(String modeloTrabalho) {
		this.modeloTrabalho = modeloTrabalho;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getDescricaoVaga() {
		return descricaoVaga;
	}

	public void setDescricaoVaga(String descricaoVaga) {
		this.descricaoVaga = descricaoVaga;
	}
	
	
	public List<CandidatoEntity> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(List<CandidatoEntity> candidatos) {
		this.candidatos = candidatos;
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
		VagaDTO other = (VagaDTO) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
