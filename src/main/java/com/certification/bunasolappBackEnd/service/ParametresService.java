package com.certification.bunasolappBackEnd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.certification.bunasolappBackEnd.entity.Parametres;
import com.certification.bunasolappBackEnd.metier.ParametresMetier;
import com.certification.bunasolappBackEnd.repository.ParametresRepository;

@Service
public class ParametresService implements ParametresMetier {

	@Autowired
	private ParametresRepository parametresRepository;

	@Override
	public List<Parametres> getListParametres() {
		return parametresRepository.findAll();
	}

	@SuppressWarnings("null")
	@Override
	public Optional<Parametres> getParametreById(Long id) {
		return parametresRepository.findById(id);
	}

	@SuppressWarnings("null")
	@Override
	public void deleteParametre(Long id) {
		Parametres existingParametres = parametresRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Parametre non trouvé avec id: " + id));
		parametresRepository.delete(existingParametres);
	}

	@SuppressWarnings("null")
	@Override
	public Parametres createParametres(Parametres parametres) {
		return parametresRepository.save(parametres);
	}

	@SuppressWarnings("null")
	@Override
	public Parametres updateParametres(Long id, Parametres new_parametres) {
		Parametres existingParametres = parametresRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Parametre non trouvé avec id: " + id));
		existingParametres.setCode_debut_enregistrement(new_parametres.getCode_debut_enregistrement());
		existingParametres.setCode_ordre(new_parametres.getCode_ordre());
		existingParametres.setLogo_labo(new_parametres.getLogo_labo());
		existingParametres.setTimbre1(new_parametres.getTimbre1());
		existingParametres.setTimbre2(new_parametres.getTimbre2());
		existingParametres.setTimbre3(new_parametres.getTimbre3());
		existingParametres.setTimbre4(new_parametres.getTimbre4());
		existingParametres.setTimbre5(new_parametres.getTimbre5());
		existingParametres.setSigle1(new_parametres.getSigle1());
		existingParametres.setSigle2(new_parametres.getSigle2());
		existingParametres.setSigle3(new_parametres.getSigle3());
		existingParametres.setSigle4(new_parametres.getSigle4());
		existingParametres.setSigle5(new_parametres.getSigle5());
		return parametresRepository.save(existingParametres);
	}
}
