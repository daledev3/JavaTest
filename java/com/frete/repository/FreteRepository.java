package com.frete.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frete.models.Frete;

@Repository
public interface FreteRepository extends JpaRepository<Frete, Long>{
	
	Frete findById(long id);

}
