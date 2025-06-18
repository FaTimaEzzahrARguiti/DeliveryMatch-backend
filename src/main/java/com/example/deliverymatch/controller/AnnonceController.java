package com.example.deliverymatch.controller;

import com.example.deliverymatch.dto.AnnonceDto;
import com.example.deliverymatch.mapper.AnnonceMapper;
import com.example.deliverymatch.model.Annonce;
import com.example.deliverymatch.service.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api/annonces")
public class AnnonceController {

    @Autowired
    private AnnonceService annonceService;

    @Autowired
    private AnnonceMapper annonceMapper;


    @PostMapping
    public ResponseEntity<Annonce> createAnnonce(@RequestBody Annonce annonce) {
        Annonce saved = annonceService.createAnnonce(annonce);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Annonce> updateAnnonce(@PathVariable Long id, @RequestBody AnnonceDto annonceDto) {
        Annonce updated = annonceService.updateAnnonce(id, annonceDto);
        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnnonce(@PathVariable Long id){
        annonceService.DeleteAnnonce(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnnonceDto> getAnnonceById(@PathVariable Long id){
        Annonce annonce=annonceService.getAnnonceById(id);
        return ResponseEntity.ok(annonceMapper.toDto(annonce));
    }

    @GetMapping
    public ResponseEntity<List<Annonce>> getAll() {
        List<Annonce> list = annonceService.gatAllAnnonces(); // ou map les entités en DTOs
        return ResponseEntity.ok(list);
    }

}
