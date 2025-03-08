package com.telmanBayram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telmanBayram.model.GaleristCar;

@Repository
public interface GaleristCarRepository extends JpaRepository<GaleristCar, Long>{
	

}
