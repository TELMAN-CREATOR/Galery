package com.telmanBayram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telmanBayram.model.Galerist;

@Repository
public interface GaleristRepository extends JpaRepository<Galerist, Long>{

}
