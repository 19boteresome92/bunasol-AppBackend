package com.certification.bunasolappBackEnd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.certification.bunasolappBackEnd.entity.ElementChimique;
import com.certification.bunasolappBackEnd.metier.ElementChimiqueMetier;
import com.certification.bunasolappBackEnd.repository.ElementChimiqueRepository;

@Service
public class ElementChimiqueService implements ElementChimiqueMetier {

	@Autowired
	private ElementChimiqueRepository elementChimiqueRepository;

	@Override
	public List<ElementChimique> getLisElementsChimiques() {
		return elementChimiqueRepository.findAll();
	}

	@SuppressWarnings("null")
	@Override
	public Optional<ElementChimique> getElementChimiqueById(Long id) {
		return elementChimiqueRepository.findById(id);
	}

	@SuppressWarnings("null")
	@Override
	public ElementChimique createElement(ElementChimique elementchimique) {
		return elementChimiqueRepository.save(elementchimique);
	}

	@SuppressWarnings("null")
	@Override
	public ElementChimique updateElementChimique(Long id, ElementChimique elementChimique) {
		ElementChimique existingElementChimique = elementChimiqueRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Echantillon non trouvé avec id: " + id));
		existingElementChimique.setDesignation(elementChimique.getDesignation());
		existingElementChimique.setFormule_chimique(elementChimique.getFormule_chimique());
		return elementChimiqueRepository.save(existingElementChimique);
	}

	@SuppressWarnings("null")
	@Override
	public void deleteElementChimique(Long id) {
		ElementChimique existingElementChimique = elementChimiqueRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Echantillon non trouvé avec id: " + id));
		elementChimiqueRepository.delete(existingElementChimique);
	}

}
