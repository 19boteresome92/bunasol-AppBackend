package com.certification.bunasolappBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.certification.bunasolappBackEnd.entity.TypeEchantillon;

@Repository
public interface TypeEchantillonRepository extends JpaRepository<TypeEchantillon, Long>{

}
