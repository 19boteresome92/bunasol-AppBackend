package com.certification.bunasolappBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.certification.bunasolappBackEnd.entity.Methode;

@Repository
public interface MethodeRepository extends JpaRepository<Methode, Long>{

}
