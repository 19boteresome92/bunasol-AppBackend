package com.certification.bunasolappBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.certification.bunasolappBackEnd.entity.ElementChimique;

@Repository
public interface ElementChimiqueRepository extends JpaRepository<ElementChimique, Long>{

}
