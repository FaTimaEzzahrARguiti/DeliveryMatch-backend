package com.example.deliverymatch.mapper;

import com.example.deliverymatch.dto.AnnonceDto;
import com.example.deliverymatch.model.Annonce;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnnonceMapper {
    @Mapping(target = "driver", ignore = true) // Ignore direct driver mapping
    Annonce toEntity(AnnonceDto dto);

    @Mapping(target = "driver_id", expression = "java(annonce.getDriver() != null ? annonce.getDriver().getId() : null)")
    AnnonceDto toDto(Annonce annonce);

    List<AnnonceDto> toDTOList(List<Annonce> annonces);
    List<Annonce> toEntityList(List<AnnonceDto> annonceDtos);
}