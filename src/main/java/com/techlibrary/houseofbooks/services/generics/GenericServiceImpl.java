package com.techlibrary.houseofbooks.services.generics;

import com.techlibrary.houseofbooks.mapper.generic.GenericMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Collectors;

public abstract class GenericServiceImpl<E,DTO, ID, M extends GenericMapper<E,DTO>>
        implements GenericService<DTO, ID> {

    protected final JpaRepository<E, ID> repository;
    protected final M mapper;

    public GenericServiceImpl(JpaRepository<E, ID> repository, M mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<DTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DTO getById(ID id) {
        E entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recurso não encontrado"));
        return mapper.toDTO(entity);
    }

    @Override
    public DTO create(DTO dto) {
        E entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public DTO update(ID id, DTO dto) {
        E entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recurso não encontrado"));
        mapper.updateEntityFromDTO(dto, entity);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public void delete(ID id) {
        repository.deleteById(id);
    }
}
