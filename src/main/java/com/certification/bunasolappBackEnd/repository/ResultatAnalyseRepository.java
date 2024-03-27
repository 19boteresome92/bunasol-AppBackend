package com.certification.bunasolappBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.certification.bunasolappBackEnd.entity.ResultatAnalyse;

@Repository
public interface ResultatAnalyseRepository extends JpaRepository<ResultatAnalyse, Long>{

}
