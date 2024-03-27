package com.certification.bunasolappBackEnd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.certification.bunasolappBackEnd.entity.Echantillon;
import com.certification.bunasolappBackEnd.metier.EchantillonMetier;
import com.certification.bunasolappBackEnd.repository.EchantillonRepository;

@Service
public class EchantillonService implements EchantillonMetier {

	@Autowired
	private EchantillonRepository echantillonRepository;

	@Override
	public List<Echantillon> getListEchantillons() {
		return echantillonRepository.findAll();
	}

	@SuppressWarnings("null")
	@Override
	public Optional<Echantillon> getEchantillonById(Long id) {
		return echantillonRepository.findById(id);
	}

	@SuppressWarnings("null")
	@Override
	public Echantillon createEchantillon(Echantillon echantillon) {
		return echantillonRepository.save(echantillon);
	}

	@Override
	public Echantillon updateEchantillon(Long id, Echantillon echantillon) {
		@SuppressWarnings("null")
		Echantillon existingEchantillon = echantillonRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Echantillon non trouvé avec id: " + id));
		existingEchantillon.setCode(echantillon.getCode());
		existingEchantillon.setLieu_prelevement(echantillon.getLieu_prelevement());
		existingEchantillon.setLot(echantillon.getLot());
		existingEchantillon.setNumero_inspection(echantillon.getNumero_inspection());
		existingEchantillon.setQuantite(echantillon.getQuantite());
		existingEchantillon.setStatut(echantillon.getStatut());
		existingEchantillon.setVille(echantillon.getVille());
		return echantillonRepository.save(existingEchantillon);
	}

	@SuppressWarnings("null")
	@Override
	public void deleteEchantillon(Long id) {
		Echantillon existingEchantillon = echantillonRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Echantillon non trouvé avec id: " + id));
		echantillonRepository.delete(existingEchantillon);
	}

}
