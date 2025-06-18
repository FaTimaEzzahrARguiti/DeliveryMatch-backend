package com.example.deliverymatch.service;

import com.example.deliverymatch.dto.AnnonceDto;
import com.example.deliverymatch.model.Annonce;

import com.example.deliverymatch.repository.AnnonceRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AnnonceService {
    private final AnnonceRepository annonceRepository;

    public AnnonceService(AnnonceRepository annonceRepository) {
        this.annonceRepository = annonceRepository;
    }


    public Annonce createAnnonce(Annonce annonce){
        return annonceRepository.save(annonce);
    }

    public List<Annonce> gatAllAnnonces(){
        return annonceRepository.findAll();
    }


    public Annonce getAnnonceById(Long id) {
        return annonceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Événement non trouvé avec id : " + id));
    }

    public Annonce updateAnnonce(Long id, AnnonceDto updateAnnonce){
        Annonce existingAnnonce= getAnnonceById(id);
existingAnnonce.setDateDepart(updateAnnonce.getDateDepart());
        existingAnnonce.setDepart(updateAnnonce.getDepart());
        existingAnnonce.setArret(updateAnnonce.getArret());
       existingAnnonce.setHeure(updateAnnonce.getHeure());
       existingAnnonce.setCapacite(updateAnnonce.getCapacite());
       existingAnnonce.setTypeColier(updateAnnonce.getTypeColier());
       existingAnnonce.setPoids(updateAnnonce.getPoids());
        return annonceRepository.save(existingAnnonce);
    }

    public void DeleteAnnonce(Long id){
        annonceRepository.deleteById(id);
    }

}
