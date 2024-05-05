package com.igor.bondezam.teste.service;

import com.igor.bondezam.teste.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrudService<E, ID> {

    @Autowired
    private CrudRepository<E, ID> repository;

    public List<E> findAll(){
        return repository.findAll();
    }

    public E findById(ID id){
        return repository.findById(id).orElse(null);
    }

    public E createOrUpdateEntity(ID id, E entity){
        return createOrUpdateEntity(entity);
    }

    public E createOrUpdateEntity(E entity){
        return repository.save(entity);
    }

    public void deleteEntity(ID id){
        repository.deleteById(id);
    }
}
