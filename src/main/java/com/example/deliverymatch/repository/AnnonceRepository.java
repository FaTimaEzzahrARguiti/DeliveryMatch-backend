package com.example.deliverymatch.repository;

import com.example.deliverymatch.model.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface AnnonceRepository extends JpaRepository<Annonce,Long>{
}
