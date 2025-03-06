package com.telmanBayram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telmanBayram.model.Adress;

@Repository
public interface AdressRepository extends JpaRepository<Adress, Long>{

}
