package com.certification.bunasolappBackEnd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.certification.bunasolappBackEnd.entity.Methode;
import com.certification.bunasolappBackEnd.metier.MethodeMetier;
import com.certification.bunasolappBackEnd.repository.MethodeRepository;

@Service
public class MethodeService implements MethodeMetier {

	@Autowired
	private MethodeRepository methodeRepository;

	@Override
	public List<Methode> getListMethodes() {
		return methodeRepository.findAll();
	}

	@SuppressWarnings("null")
	@Override
	public Optional<Methode> getMethodeById(Long id) {
		return methodeRepository.findById(id);
	}

	@SuppressWarnings("null")
	@Override
	public Methode createMethode(Methode new_methode) {
		return methodeRepository.save(new_methode);
	}

	@SuppressWarnings("null")
	@Override
	public Methode updateMethode(Long id, Methode updatedmethode) {
		Methode existingMethode = methodeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Echantillon non trouvé avec id: " + id));
		existingMethode.setIntitule(updatedmethode.getIntitule());
		return methodeRepository.save(existingMethode);
	}

	@SuppressWarnings("null")
	@Override
	public void deleteMethode(Long id) {
		Methode existingMethode = methodeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Echantillon non trouvé avec id: " + id));
		methodeRepository.delete(existingMethode);
	}

}
