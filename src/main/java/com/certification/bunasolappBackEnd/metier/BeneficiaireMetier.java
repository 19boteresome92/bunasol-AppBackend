package com.certification.bunasolappBackEnd.metier;

import java.util.List;
import java.util.Optional;

import com.certification.bunasolappBackEnd.entity.Beneficiaire;

public interface BeneficiaireMetier {

	List<Beneficiaire> getListBeneficiaires();

	Optional<Beneficiaire> getBeneficiaireById(Long id);

	Beneficiaire createBeneficiaire(Beneficiaire beneficiaire);

	Beneficiaire updateBeneficiaire(Long id, Beneficiaire beneficiaire);

	void deleteBeneficiaire(Long id);
}
