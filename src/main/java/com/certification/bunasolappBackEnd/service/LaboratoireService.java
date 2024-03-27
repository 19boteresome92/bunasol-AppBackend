package com.certification.bunasolappBackEnd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.certification.bunasolappBackEnd.entity.Laboratoire;
import com.certification.bunasolappBackEnd.metier.LaboratoireMetier;
import com.certification.bunasolappBackEnd.repository.LaboratoireRepository;

@Service
public class LaboratoireService implements LaboratoireMetier {

	@Autowired
	private LaboratoireRepository laboratoireRepository;

	@Override
	public List<Laboratoire> getListLaboratoires() {
		return laboratoireRepository.findAll();
	}

	@SuppressWarnings("null")
	@Override
	public Optional<Laboratoire> getLaboratoireById(Long id) {
		return laboratoireRepository.findById(id);
	}

	@SuppressWarnings("null")
	@Override
	public Laboratoire createLaboratoire(Laboratoire laboratoire) {
		return laboratoireRepository.save(laboratoire);
	}

	@SuppressWarnings("null")
	@Override
	public Laboratoire updateLaboratoire(Long id, Laboratoire laboratoire) {
		Laboratoire existingLaboratoire = laboratoireRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Echantillon non trouvé avec id: " + id));
		existingLaboratoire.setCode_labo(laboratoire.getCode_labo());
		existingLaboratoire.setNom_labo(laboratoire.getNom_labo());
		return laboratoireRepository.save(existingLaboratoire);
	}

	@SuppressWarnings("null")
	@Override
	public void deleteLaboratoire(Long id) {
		Laboratoire existingLaboratoire = laboratoireRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Echantillon non trouvé avec id: " + id));
		laboratoireRepository.delete(existingLaboratoire);
	}

}
