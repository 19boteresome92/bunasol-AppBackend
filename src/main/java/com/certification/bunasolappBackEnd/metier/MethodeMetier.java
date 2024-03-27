package com.certification.bunasolappBackEnd.metier;

import java.util.List;
import java.util.Optional;

import com.certification.bunasolappBackEnd.entity.Methode;

public interface MethodeMetier {

	List<Methode> getListMethodes();

	Optional<Methode> getMethodeById(Long id);

	Methode createMethode(Methode methode);

	Methode updateMethode(Long id, Methode methode);

	void deleteMethode(Long id);
}
