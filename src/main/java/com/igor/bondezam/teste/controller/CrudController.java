package com.igor.bondezam.teste.controller;

import com.igor.bondezam.teste.converter.CrudConverter;
import com.igor.bondezam.teste.domain.Usuario;
import com.igor.bondezam.teste.interfaces.SaveEntity;
import com.igor.bondezam.teste.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

public abstract class CrudController<E extends SaveEntity<ID>, ID, EREQ, ERES> {

    @Autowired
    private CrudService<E, ID> service;

    @Autowired
    private CrudConverter<E, EREQ, ERES> converter;

    public CrudService<E, ID> getService() {
        return this.service;
    }

    @GetMapping
    public ResponseEntity<List<ERES>> findAll(){
        return ResponseEntity.ok(service.findAll().stream().map(
                converter::entityToRes).collect(Collectors.toList()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ERES> findById(@PathVariable("id") ID id){
        return ResponseEntity.ok(converter.entityToRes(service.findById(id)));
    }

    @PostMapping
    public ResponseEntity<ERES> createUsuario(@RequestBody EREQ req){
        ERES saved =
                converter.entityToRes(
                        service.createOrUpdateEntity(
                                converter.reqToEntity(req)));
        return ResponseEntity.status(201).body(saved);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ERES> updateUsuario(@PathVariable("id") ID id, @RequestBody EREQ req){
        return ResponseEntity.ok(converter.entityToRes(service.createOrUpdateEntity(id, converter.reqToEntity(req))));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable("id") ID id){
        service.deleteEntity(id);
        return ResponseEntity.noContent().build();
    }
}
