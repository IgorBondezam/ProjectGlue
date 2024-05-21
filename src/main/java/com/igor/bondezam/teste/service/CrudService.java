package com.igor.bondezam.teste.service;

import com.igor.bondezam.teste.interfaces.SaveEntity;
import com.igor.bondezam.teste.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class CrudService<E extends SaveEntity<ID>, ID> {

    @Autowired
    private CrudRepository<E, ID> repository;

    public List<E> findAll(){
        return repository.findAll();
    }

    public E findById(ID id){
        return repository.findById(id).orElse(null);
    }

    public E createOrUpdateEntity(ID id, E entity){
        entity.setId(id);
        return createOrUpdateEntity(entity);
    }

    public E createOrUpdateEntity(E entity){
        return repository.save(entity);
    }

    public void deleteEntity(ID id){
        repository.deleteById(id);
    }
}
