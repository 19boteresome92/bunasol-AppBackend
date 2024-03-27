package com.certification.bunasolappBackEnd.metier;

import java.util.List;
import java.util.Optional;

import com.certification.bunasolappBackEnd.entity.Echantillon;

public interface EchantillonMetier {

	List<Echantillon> getListEchantillons();

	Optional<Echantillon> getEchantillonById(Long id);

	Echantillon createEchantillon(Echantillon echantillon);

	Echantillon updateEchantillon(Long id, Echantillon echantillon);

	void deleteEchantillon(Long id);
}
