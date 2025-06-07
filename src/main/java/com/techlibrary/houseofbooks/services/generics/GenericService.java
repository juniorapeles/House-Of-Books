package com.techlibrary.houseofbooks.services.generics;

import java.util.List;

public interface GenericService<DTO, ID> {
    List<DTO> getAll();
    DTO getById(ID id);
    DTO create(DTO dto);
    DTO update(ID id, DTO dto);
    void delete(ID id);
}