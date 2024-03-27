package com.certification.bunasolappBackEnd.metier;

import java.util.List;
import java.util.Optional;

import com.certification.bunasolappBackEnd.entity.TypeAnalyse;

public interface TypeAnalyseMetier {

	List<TypeAnalyse> getListTypeAnalyses();

	Optional<TypeAnalyse> getTypeAnalyseById(Long id);

	TypeAnalyse createTypeAnalyse(TypeAnalyse typeAnalyse);

	TypeAnalyse updateTypeAnalyse(Long id, TypeAnalyse typeAnalyse);

	void deleteTypeAnalyse(Long id);
}
