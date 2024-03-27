package com.certification.bunasolappBackEnd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.certification.bunasolappBackEnd.entity.Beneficiaire;
import com.certification.bunasolappBackEnd.metier.BeneficiaireMetier;
import com.certification.bunasolappBackEnd.repository.BeneficiaireRepository;

@Service
public class BeneficiaireService implements BeneficiaireMetier {

	@Autowired
	private BeneficiaireRepository beneficiaireRepository;

	@Override
	public List<Beneficiaire> getListBeneficiaires() {
		return beneficiaireRepository.findAll();
	}

	@SuppressWarnings("null")
	@Override
	public Optional<Beneficiaire> getBeneficiaireById(Long id) {
		return beneficiaireRepository.findById(id);
	}

	@SuppressWarnings("null")
	@Override
	public Beneficiaire createBeneficiaire(Beneficiaire beneficiaire) {
		return beneficiaireRepository.save(beneficiaire);
	}

	@Override
	public Beneficiaire updateBeneficiaire(Long id, Beneficiaire beneficiaire) {
		@SuppressWarnings("null")
		Beneficiaire existingBeneficiaire = beneficiaireRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Beneficiaire non trouvée avec id: " + id));
		existingBeneficiaire.setAdresse(beneficiaire.getAdresse());
		existingBeneficiaire.setContact(beneficiaire.getContact());
		existingBeneficiaire.setEmail(beneficiaire.getEmail());
		existingBeneficiaire.setNom(beneficiaire.getNom());
		return beneficiaireRepository.save(existingBeneficiaire);
	}

	@SuppressWarnings("null")
	@Override
	public void deleteBeneficiaire(Long id) {
		Beneficiaire existingBeneficiaire = beneficiaireRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Beneficiaire non trouvée avec id: " + id));
		beneficiaireRepository.delete(existingBeneficiaire);
	}

}
