package com.cacatrampo.dto;

import java.util.Date;
import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.cacatrampo.entities.VagaEntity;



public class VagaDTO {
	
	private Long id;
	private String titulo;
	private Date dataPostagem;
	private Double salario;
	private String tipoContratacao;
	private String modeloTrabalho;
	private String local;
	private String nomeEmpresa;
	private String descricaoVaga;	


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

	public Date getDataPostagem() {
		return dataPostagem;
	}

	public void setDataPostagem(Date dataPostagem) {
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
