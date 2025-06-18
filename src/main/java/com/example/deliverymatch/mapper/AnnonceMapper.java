package com.example.deliverymatch.mapper;

import com.example.deliverymatch.dto.AnnonceDto;
import com.example.deliverymatch.model.Annonce;
import org.springframework.stereotype.Component;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnnonceMapper {
    Annonce toEntity(AnnonceDto DTO);
    AnnonceDto toDto(Annonce entity);
    List<AnnonceDto> toDTOList(List<Annonce> annonces);
    List<Annonce> toEntityList(List<AnnonceDto> annonceDtos);


}
