package com.certification.bunasolappBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.certification.bunasolappBackEnd.entity.Parametres;

@Repository
public interface ParametresRepository extends JpaRepository<Parametres, Long>{

}
