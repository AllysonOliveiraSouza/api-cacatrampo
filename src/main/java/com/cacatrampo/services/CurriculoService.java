package com.cacatrampo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cacatrampo.dto.CurriculoDTO;
import com.cacatrampo.entities.CurriculoEntity;
import com.cacatrampo.repositories.CurriculoRepository;

@Service
public class CurriculoService {
	@Autowired
	private CurriculoRepository curriculoRepository;
	
	public List<CurriculoDTO> listarCurriculos(){
		List<CurriculoEntity> listaCurriculos = curriculoRepository.findAll();		
		return listaCurriculos.stream().map(CurriculoDTO::new).toList();
	}
	
	public void adicionarCurriculo(CurriculoDTO curriculo) {
		CurriculoEntity curriculoEntity = new CurriculoEntity(curriculo);
		curriculoRepository.save(curriculoEntity);
	}

	public CurriculoDTO alterarCurriculo(CurriculoDTO curriculo) {
		CurriculoEntity curriculoEntity = new CurriculoEntity(curriculo);
		return new CurriculoDTO(curriculoRepository.save(curriculoEntity));
	}

	public void excluirCurriculo(Long id) {
		CurriculoEntity curriculoEntity = curriculoRepository.findById(id).get();
		curriculoRepository.delete(curriculoEntity);
	}
	
	public CurriculoDTO buscarPorID(Long id) {
		return new CurriculoDTO(curriculoRepository.findById(id).get());
	}
	

}
