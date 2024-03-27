package com.certification.bunasolappBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.certification.bunasolappBackEnd.entity.Laboratoire;

@Repository
public interface LaboratoireRepository extends JpaRepository<Laboratoire, Long>{

}
