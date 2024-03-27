package com.certification.bunasolappBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.certification.bunasolappBackEnd.entity.Echantillon;

@Repository
public interface EchantillonRepository extends JpaRepository<Echantillon, Long>{

}
