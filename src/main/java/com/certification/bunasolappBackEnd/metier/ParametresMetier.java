package com.certification.bunasolappBackEnd.metier;

import java.util.List;
import java.util.Optional;

import com.certification.bunasolappBackEnd.entity.Parametres;

public interface ParametresMetier {

	List<Parametres> getListParametres();

	Optional<Parametres> getParametreById(Long id);

	Parametres createParametres(Parametres parametres);

	Parametres updateParametres(Long id, Parametres parametres);

	void deleteParametre(Long id);
}
