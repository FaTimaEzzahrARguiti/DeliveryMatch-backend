package com.example.deliverymatch.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String depart;
    private String heure;
    private LocalDate dateDepart;
    private String arret;
    private String capacite;
    private String typeColier;
    private Double poids;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id", referencedColumnName = "id", nullable = true)
    private Driver driver; // Single point of reference for the driver relationship

    // Getter and setter for driverId derived from driver
    public Long getDriverId() {
        return driver != null ? driver.getId() : null;
    }

    public void setDriverId(Long driverId) {
        // This method is optional and can be used if you need to set driverId directly
        if (driverId != null) {
            this.driver = new Driver(); // Create a new Driver instance (adjust as needed)
            this.driver.setId(driverId);
        } else {
            this.driver = null;
        }
    }
}