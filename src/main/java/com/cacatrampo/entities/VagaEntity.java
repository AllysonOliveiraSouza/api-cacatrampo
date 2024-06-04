package com.cacatrampo.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.cacatrampo.dto.VagaDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
	private LocalDate dataPostagem;
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
	@ManyToOne
	@JoinColumn(name="administrador_id")
	private AdministradorEntity administrador;

	@JsonIgnore
	@ManyToMany(mappedBy = "vagas", cascade = CascadeType.ALL)
	private List<CandidatoEntity> candidatos;
	
	public VagaEntity() {}
	
	public VagaEntity(VagaDTO vaga) {
		BeanUtils.copyProperties(vaga, this);
	}

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

	public void setNomeEmpresa(String nomeempresa) {
		this.nomeEmpresa = nomeempresa;
	}

	public String getDescricaoVaga() {
		return descricaoVaga;
	}

	public void setDescricaoVaga(String descricaoVaga) {
		this.descricaoVaga = descricaoVaga;
	}
	
		
	public AdministradorEntity getAdministrador() {
		return administrador;
	}

	public void setAdministrador(AdministradorEntity administrador) {
		this.administrador = administrador;
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
		VagaEntity other = (VagaEntity) obj;
		return Objects.equals(id, other.id);
	}
		

}
