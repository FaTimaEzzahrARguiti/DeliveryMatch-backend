package com.example.deliverymatch.service;

import com.example.deliverymatch.dto.AnnonceDto;
import com.example.deliverymatch.model.Annonce;
import com.example.deliverymatch.repository.AnnonceRepository;
import com.example.deliverymatch.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.sql.Driver;
import java.util.List;

@Service
public class AnnonceService {
    private final AnnonceRepository annonceRepository;
    private final DriverRepository driverRepository;

    public AnnonceService(AnnonceRepository annonceRepository, DriverRepository driverRepository) {
        this.annonceRepository = annonceRepository;
        this.driverRepository = driverRepository;
    }

    public Annonce createAnnonce(Annonce annonce) {
        if (annonce.getDriver() != null) {
            driverRepository.findById(annonce.getDriver().getId())
                    .orElseThrow(() -> new RuntimeException("Driver not found"));
        }
        return annonceRepository.save(annonce);
    }

    public List<Annonce> getAllAnnonces() {
        return annonceRepository.findAll();
    }

    public Annonce getAnnonceById(Long id) {
        return annonceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Événement non trouvé avec id : " + id));
    }

    public Annonce updateAnnonce(Long id, AnnonceDto updateAnnonce) {
        Annonce existingAnnonce = getAnnonceById(id);
        existingAnnonce.setDateDepart(updateAnnonce.getDateDepart());
        existingAnnonce.setDepart(updateAnnonce.getDepart());
        existingAnnonce.setArret(updateAnnonce.getArret());
        existingAnnonce.setHeure(updateAnnonce.getHeure());
        existingAnnonce.setCapacite(updateAnnonce.getCapacite());
        existingAnnonce.setTypeColier(updateAnnonce.getTypeColier());
        existingAnnonce.setPoids(updateAnnonce.getPoids());
        if (updateAnnonce.getDriver_id() != null) {
            Driver driver = (Driver) driverRepository.findById(updateAnnonce.getDriver_id())
                    .orElseThrow(() -> new RuntimeException("Driver not found"));
            existingAnnonce.setDriver((com.example.deliverymatch.model.Driver) driver);
        }
        return annonceRepository.save(existingAnnonce);
    }

    public void deleteAnnonce(Long id) {
        annonceRepository.deleteById(id);
    }
}