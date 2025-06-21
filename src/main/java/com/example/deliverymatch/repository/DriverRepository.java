package com.example.deliverymatch.repository;

import com.example.deliverymatch.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}