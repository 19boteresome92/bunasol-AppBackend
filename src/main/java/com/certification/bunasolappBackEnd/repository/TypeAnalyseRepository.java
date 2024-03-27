package com.certification.bunasolappBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.certification.bunasolappBackEnd.entity.TypeAnalyse;

@Repository
public interface TypeAnalyseRepository extends JpaRepository<TypeAnalyse, Long>{

}
