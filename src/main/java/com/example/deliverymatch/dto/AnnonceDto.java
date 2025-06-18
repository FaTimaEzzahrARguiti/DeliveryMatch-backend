package com.example.deliverymatch.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AnnonceDto {
    private Long id;
    private String depart;
    private String heure;
    private LocalDate dateDepart;
    private String arret;
    private String capacite;
    private String typeColier;
    private Double poids;
}
