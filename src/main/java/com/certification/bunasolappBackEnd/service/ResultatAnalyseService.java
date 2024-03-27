package com.certification.bunasolappBackEnd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.certification.bunasolappBackEnd.entity.ResultatAnalyse;
import com.certification.bunasolappBackEnd.metier.ResultatAnalyseMetier;
import com.certification.bunasolappBackEnd.repository.ResultatAnalyseRepository;

@Service
public class ResultatAnalyseService implements ResultatAnalyseMetier {

	@Autowired
	private ResultatAnalyseRepository resultatAnalyseRepository;

	@Override
	public List<ResultatAnalyse> getListResultatsAnalyses() {
		return resultatAnalyseRepository.findAll();
	}

	@SuppressWarnings("null")
	@Override
	public Optional<ResultatAnalyse> getResultatById(Long id) {
		return resultatAnalyseRepository.findById(id);
	}

	@SuppressWarnings("null")
	@Override
	public ResultatAnalyse createResultatAnalyse(ResultatAnalyse new_resultatAnalyse) {
		return resultatAnalyseRepository.save(new_resultatAnalyse);
	}

	@SuppressWarnings("null")
	@Override
	public ResultatAnalyse updateResultatAnalyse(Long id, ResultatAnalyse updateResultatAnalyse) {
		ResultatAnalyse existingResultatAnalyse = resultatAnalyseRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Resultat analyse non trouvé avec id: " + id));
		existingResultatAnalyse.setValeur_trouve(updateResultatAnalyse.getValeur_trouve());
		return resultatAnalyseRepository.save(existingResultatAnalyse);
	}

	@SuppressWarnings("null")
	@Override
	public void deleteResultatAnalyse(Long id) {
		ResultatAnalyse existingResultatAnalyse = resultatAnalyseRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Resultat Analyse non trouvé avec id: " + id));
		resultatAnalyseRepository.delete(existingResultatAnalyse);
	}

}
