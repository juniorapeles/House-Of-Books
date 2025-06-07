package com.techlibrary.generics;

import org.mapstruct.MappingTarget;

public interface GenericMapper<E,DTO> {
    E toEntity(DTO dto);
    DTO toDTO(E entity);
    void updateEntityFromDTO(DTO dto, @MappingTarget E entity);
}
