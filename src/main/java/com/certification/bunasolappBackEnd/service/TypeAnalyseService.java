package com.certification.bunasolappBackEnd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.certification.bunasolappBackEnd.entity.TypeAnalyse;
import com.certification.bunasolappBackEnd.metier.TypeAnalyseMetier;
import com.certification.bunasolappBackEnd.repository.TypeAnalyseRepository;

@Service
public class TypeAnalyseService implements TypeAnalyseMetier {

	@Autowired
	private TypeAnalyseRepository typeAnalyseRepository;

	@Override
	public List<TypeAnalyse> getListTypeAnalyses() {
		return typeAnalyseRepository.findAll();
	}

	@SuppressWarnings("null")
	@Override
	public Optional<TypeAnalyse> getTypeAnalyseById(Long id) {
		return typeAnalyseRepository.findById(id);
	}

	@SuppressWarnings("null")
	@Override
	public TypeAnalyse createTypeAnalyse(TypeAnalyse new_typeAnalyse) {
		return typeAnalyseRepository.save(new_typeAnalyse);
	}

	@SuppressWarnings("null")
	@Override
	public TypeAnalyse updateTypeAnalyse(Long id, TypeAnalyse updateTypeAnalyse) {
		TypeAnalyse existingTypeAnalyse = typeAnalyseRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("type analyse non trouvé avec id: " + id));
		existingTypeAnalyse.setType_controle(updateTypeAnalyse.getType_controle());
		return typeAnalyseRepository.save(existingTypeAnalyse);
	}

	@SuppressWarnings("null")
	@Override
	public void deleteTypeAnalyse(Long id) {
		TypeAnalyse existingTypeAnalyse = typeAnalyseRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("type analyse non trouvé avec id: " + id));
		typeAnalyseRepository.delete(existingTypeAnalyse);
	}

}
