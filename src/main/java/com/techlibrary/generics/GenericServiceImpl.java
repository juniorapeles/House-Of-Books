package com.techlibrary.generics;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class GenericServiceImpl<E, DTO, ID, M extends GenericMapper<E, DTO>>
        implements GenericService<DTO, ID> {

    protected final JpaRepository<E, ID> repository;
    protected final M mapper;

    protected GenericServiceImpl(JpaRepository<E, ID> repository, M mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<DTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Override
    public DTO getById(ID id) {
        E entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entidade não encontrada"));
        return mapper.toDTO(entity);
    }

    @Override
    public DTO create(DTO dto) {
        E entity = mapper.toEntity(dto);
        E saved = repository.save(entity);
        return mapper.toDTO(saved);
    }

    @Override
    public DTO update(ID id, DTO dto) {
        E entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entidade não encontrada"));

        mapper.updateEntityFromDTO(dto, entity);
        E updated = repository.save(entity);
        return mapper.toDTO(updated);
    }

    @Override
    public void delete(ID id) {
        repository.deleteById(id);
    }
}