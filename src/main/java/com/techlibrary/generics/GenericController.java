package com.techlibrary.generics;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class GenericController<DTO, ID> {

    protected final GenericService<DTO, ID> service;

    protected GenericController(GenericService<DTO, ID> service) {
        this.service = service;
    }

    @GetMapping
    public List<DTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public DTO getById(@PathVariable ID id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DTO create(@RequestBody DTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public DTO update(@PathVariable ID id, @RequestBody DTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable ID id) {
        service.delete(id);
    }
}
