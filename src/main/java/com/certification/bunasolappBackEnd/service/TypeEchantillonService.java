package com.certification.bunasolappBackEnd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.certification.bunasolappBackEnd.entity.TypeEchantillon;
import com.certification.bunasolappBackEnd.metier.TypeEchantillonMetier;
import com.certification.bunasolappBackEnd.repository.TypeEchantillonRepository;

@Service
public class TypeEchantillonService implements TypeEchantillonMetier {

	@Autowired
	private TypeEchantillonRepository typeEchantillonRepository;

	@Override
	public List<TypeEchantillon> getListTypeEchantillons() {
		return typeEchantillonRepository.findAll();
	}

	@SuppressWarnings("null")
	@Override
	public Optional<TypeEchantillon> getTypeEchantillonById(Long id) {
		return typeEchantillonRepository.findById(id);
	}

	@SuppressWarnings("null")
	@Override
	public TypeEchantillon createTypeEchantillon(TypeEchantillon new_typeEchantillon) {
		return typeEchantillonRepository.save(new_typeEchantillon);
	}

	@SuppressWarnings("null")
	@Override
	public TypeEchantillon updateTypeEchantillon(Long id, TypeEchantillon updateTypeEchantillon) {
		TypeEchantillon existingTypeEchantillon = typeEchantillonRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("type echantillon non trouvé avec id: " + id));
		existingTypeEchantillon.setLibelle(updateTypeEchantillon.getLibelle());
		return typeEchantillonRepository.save(existingTypeEchantillon);
	}

	@SuppressWarnings("null")
	@Override
	public void deleteTypeEchantillon(Long id) {
		TypeEchantillon existingTypeEchantillon = typeEchantillonRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("type echantillon non trouvé avec id: " + id));
		typeEchantillonRepository.delete(existingTypeEchantillon);
	}

}
