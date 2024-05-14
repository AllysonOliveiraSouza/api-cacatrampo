package com.cacatrampo.entities;

import java.util.Date;
import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.cacatrampo.dto.VagaDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Vagas")
public class VagaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false)
	private String titulo;
	@Column(nullable=false,name="data_postagem")
	private Date dataPostagem;
	@Column(nullable=false)
	private Double salario;
	@Column(nullable=false,name="tipo_contratacao")
	private String tipoContratacao;
	@Column(nullable=false,name="modelo_trabalho")
	private String modeloTrabalho;
	@Column(nullable=false)
	private String local;
	@Column(nullable=false,name="nome_empresa")
	private String nomeEmpresa;
	@Column(nullable=false,name="descricao_vaga")
	private String descricaoVaga;
	
	public VagaEntity(VagaDTO vaga) {
		BeanUtils.copyProperties(vaga, this);
	}
	
	public VagaEntity() {}

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

	public void setNomeEmpresa(String nomeempresa) {
		this.nomeEmpresa = nomeempresa;
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
		VagaEntity other = (VagaEntity) obj;
		return Objects.equals(id, other.id);
	}
		

}