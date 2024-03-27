package com.certification.bunasolappBackEnd.metier;

import java.util.List;
import java.util.Optional;

import com.certification.bunasolappBackEnd.entity.ResultatAnalyse;

public interface ResultatAnalyseMetier {

	List<ResultatAnalyse> getListResultatsAnalyses();

	Optional<ResultatAnalyse> getResultatById(Long id);

	ResultatAnalyse createResultatAnalyse(ResultatAnalyse resultatAnalyse);

	ResultatAnalyse updateResultatAnalyse(Long id, ResultatAnalyse resultatAnalyse);

	void deleteResultatAnalyse(Long id);
}
