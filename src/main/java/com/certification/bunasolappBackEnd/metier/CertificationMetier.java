package com.certification.bunasolappBackEnd.metier;

import java.util.List;
import java.util.Optional;

import com.certification.bunasolappBackEnd.entity.Certification;

public interface CertificationMetier {

	List<Certification> getListCertifications();

	Optional<Certification> getCertificationById(Long id);

	Certification createCertification(Certification certification);

	Certification updateCertification(Long id, Certification certification);

	void deleteCertification(Long id);
}
