package com.techlibrary.generics;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class GenericServiceImpl<ENTITY, DTO, ID, MAPPER extends GenericMapper<ENTITY, DTO>>
        implements GenericService<DTO, ID> {

    protected final JpaRepository<ENTITY, ID> repository;
    protected final MAPPER mapper;

    protected GenericServiceImpl(JpaRepository<ENTITY, ID> repository, MAPPER mapper) {
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
        ENTITY entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entidade não encontrada"));
        return mapper.toDTO(entity);
    }

    @Override
    public DTO create(DTO dto) {
        ENTITY entity = mapper.toEntity(dto);
        ENTITY saved = repository.save(entity);
        return mapper.toDTO(saved);
    }

    @Override
    public DTO update(ID id, DTO dto) {
        ENTITY entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entidade não encontrada"));

        mapper.updateEntityFromDTO(dto, entity);
        ENTITY updated = repository.save(entity);
        return mapper.toDTO(updated);
    }

    @Override
    public void delete(ID id) {
        repository.deleteById(id);
    }
}