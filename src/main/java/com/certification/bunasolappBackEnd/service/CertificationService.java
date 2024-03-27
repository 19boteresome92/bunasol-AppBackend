package com.certification.bunasolappBackEnd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.certification.bunasolappBackEnd.entity.Certification;
import com.certification.bunasolappBackEnd.metier.CertificationMetier;
import com.certification.bunasolappBackEnd.repository.CertificationRepository;

@Service
public class CertificationService implements CertificationMetier {

	@Autowired
	private CertificationRepository certificationRepository;

	@Override
	public List<Certification> getListCertifications() {
		return certificationRepository.findAll();
	}

	@SuppressWarnings("null")
	@Override
	public Optional<Certification> getCertificationById(Long id) {
		return certificationRepository.findById(id);
	}

	@SuppressWarnings("null")
	@Override
	public Certification createCertification(Certification certification) {
		return certificationRepository.save(certification);
	}

	@SuppressWarnings("null")
	@Override
	public Certification updateCertification(Long id, Certification updatecertification) {
		Certification existingCertification = certificationRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Beneficiaire non trouvée avec id: " + id));
		existingCertification.setDate_certification(updatecertification.getDate_certification());
		existingCertification.setNumero_ordre(updatecertification.getNumero_ordre());
		existingCertification.setObservations(updatecertification.getObservations());
		return certificationRepository.save(existingCertification);
	}

	@SuppressWarnings("null")
	@Override
	public void deleteCertification(Long id) {
		Certification existingCertification = certificationRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Beneficiaire non trouvée avec id: " + id));
		certificationRepository.delete(existingCertification);
	}

}
