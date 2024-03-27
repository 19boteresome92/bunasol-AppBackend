package com.certification.bunasolappBackEnd.metier;

import java.util.List;
import java.util.Optional;

import com.certification.bunasolappBackEnd.entity.Laboratoire;

public interface LaboratoireMetier {

	List<Laboratoire> getListLaboratoires();

	Optional<Laboratoire> getLaboratoireById(Long id);

	Laboratoire createLaboratoire(Laboratoire laboratoire);

	Laboratoire updateLaboratoire(Long id, Laboratoire laboratoire);

	void deleteLaboratoire(Long id);
}
