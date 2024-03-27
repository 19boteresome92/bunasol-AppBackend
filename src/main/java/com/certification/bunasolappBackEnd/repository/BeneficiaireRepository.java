package com.certification.bunasolappBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.certification.bunasolappBackEnd.entity.Beneficiaire;

@Repository
public interface BeneficiaireRepository extends JpaRepository<Beneficiaire, Long>{

}
