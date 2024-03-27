package com.certification.bunasolappBackEnd.metier;

import java.util.List;
import java.util.Optional;

import com.certification.bunasolappBackEnd.entity.ElementChimique;

public interface ElementChimiqueMetier {

	List<ElementChimique> getLisElementsChimiques();

	Optional<ElementChimique> getElementChimiqueById(Long id);

	ElementChimique createElement(ElementChimique chimique);

	ElementChimique updateElementChimique(Long id, ElementChimique elementChimique);

	void deleteElementChimique(Long id);
}
