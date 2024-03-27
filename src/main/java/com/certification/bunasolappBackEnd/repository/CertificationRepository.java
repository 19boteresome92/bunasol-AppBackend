package com.certification.bunasolappBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.certification.bunasolappBackEnd.entity.Certification;

@Repository
public interface CertificationRepository extends JpaRepository<Certification, Long>{

}
