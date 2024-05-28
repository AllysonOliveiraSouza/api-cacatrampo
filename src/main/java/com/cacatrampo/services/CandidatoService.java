package com.cacatrampo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cacatrampo.dto.CandidatoDTO;
import com.cacatrampo.entities.CandidatoEntity;
import com.cacatrampo.entities.VagaEntity;
import com.cacatrampo.repositories.CandidatoRepository;
import com.cacatrampo.repositories.VagaRepository;

@Service
public class CandidatoService {

	@Autowired
	private CandidatoRepository candidatoRepository;
	@Autowired
	private VagaRepository vagaRepository;
	@Autowired
	private VagaService vagaService;
	
	public List<CandidatoDTO> listarCandidatos() {
		List<CandidatoEntity> listaCandidatos = candidatoRepository.findAll();
		return listaCandidatos.stream().map(CandidatoDTO::new).toList();
	}

	public void adicionarCandidato(CandidatoDTO candidato) {
		CandidatoEntity candidatoEntity = new CandidatoEntity(candidato);
		candidatoRepository.save(candidatoEntity);
	}

	public CandidatoDTO alterarCandidato(CandidatoDTO candidato) {
		CandidatoEntity candidatoEntity = new CandidatoEntity(candidato);
		return new CandidatoDTO(candidatoRepository.save(candidatoEntity));
	}

	public void excluirCandidato(Long id) {
		CandidatoEntity candidatoEntity = candidatoRepository.findById(id).get();
		candidatoRepository.delete(candidatoEntity);
	}
	
	public CandidatoDTO buscarPorID(Long id) {
		return new CandidatoDTO(candidatoRepository.findById(id).get());
	}
	
	public Boolean validarLogin(String email) {	

		try {
		 CandidatoDTO candidato = new CandidatoDTO(candidatoRepository.findByEmail(email));
		 if(candidato.getEmail().contentEquals(email)){
			 return true;
		 }
		}catch(Exception e) {
			System.out.println("Login não encontrado !");
		}
		return false;
	}
	

	
	
	
	public CandidatoDTO enviarCurriculo(Long idVaga, Long idCandidato) {
		VagaEntity vaga = new VagaEntity(vagaService.buscarVagaPorID(idVaga));
		CandidatoEntity candidato = new CandidatoEntity(buscarPorID(idCandidato));
		candidato.getVagas().add(vaga);
		vagaRepository.save(vaga);	
		candidatoRepository.save(candidato);	
		return new CandidatoDTO(candidato);
	}
	
	public CandidatoDTO logar(String email, String senha){	
		
		Boolean loginExiste = validarLogin(email);
		if(loginExiste) {
			 return new CandidatoDTO(candidatoRepository.findByEmail(email));
		}else {
			return new CandidatoDTO();
		}
		
	}	

}
