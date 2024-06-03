package com.cacatrampo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cacatrampo.dto.CandidatoDTO;
import com.cacatrampo.entities.CandidatoEntity;
import com.cacatrampo.repositories.CandidatoRepository;

@Service
public class CandidatoService {

	@Autowired
	private CandidatoRepository candidatoRepository;
	
	public List<CandidatoDTO> listarCandidatos() {
		List<CandidatoEntity> listaCandidatos = candidatoRepository.findAll();
		return listaCandidatos.stream().map(CandidatoDTO::new).toList();
	}

	public Long adicionarCandidato(CandidatoDTO candidato) {
		CandidatoEntity candidatoEntity = new CandidatoEntity(candidato);
		CandidatoDTO candidatoCadastrado = 
				new CandidatoDTO(candidatoRepository.save(candidatoEntity));
		return candidatoCadastrado.getId();		
	}

	public CandidatoDTO alterarCandidato(CandidatoDTO candidato) {
		CandidatoDTO candidatoBackEnd = buscarPorID(candidato.getId());
		CandidatoDTO candidatoFrontEnd = candidato;
		
		if(candidatoFrontEnd.getNome()=="")
			candidatoFrontEnd.setNome(candidatoBackEnd.getNome());
		if(candidatoFrontEnd.getEmail()=="")
			candidatoFrontEnd.setEmail(candidatoBackEnd.getEmail());
		if(candidatoFrontEnd.getSenha()=="")
			candidatoFrontEnd.setSenha(candidatoBackEnd.getSenha());
		if(candidatoFrontEnd.getMatricula()=="")
			candidatoFrontEnd.setMatricula(candidatoBackEnd.getMatricula());
		if(candidatoFrontEnd.getTelContato()=="")
			candidatoFrontEnd.setTelContato(candidatoBackEnd.getTelContato());
		
		candidatoFrontEnd.setCurriculo(candidatoBackEnd.getCurriculo());
		candidatoFrontEnd.setVagas(candidatoBackEnd.getVagas());		
		
		CandidatoEntity candidatoEntity = new CandidatoEntity(candidatoFrontEnd);
	    return new CandidatoDTO(candidatoRepository.save(candidatoEntity));
	}

	public void excluirCandidato(Long id) {
		CandidatoEntity candidatoEntity = candidatoRepository.findById(id).get();
		candidatoRepository.delete(candidatoEntity);
	}
	
	public CandidatoDTO buscarPorID(Long id) {
		return new CandidatoDTO(candidatoRepository.findById(id).get());
	}
	
	public CandidatoDTO logar(CandidatoDTO candidato) {
		try {
			CandidatoDTO candidatoLogin = new CandidatoDTO
				(candidatoRepository.findByEmail(candidato.getEmail()));		
		if((candidato.getSenha().contentEquals(candidatoLogin.getSenha()))) {
			return candidatoLogin;
		}		
		}catch(Exception e) {
			System.out.println("Login não localizado ! "+e.getMessage());
		}
		return new CandidatoDTO();
	}
	

	
	
	

	

	
	
	

	


}
