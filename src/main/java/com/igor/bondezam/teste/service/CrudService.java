package com.igor.bondezam.teste.service;

import com.igor.bondezam.teste.interfaces.SaveEntity;
import com.igor.bondezam.teste.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class CrudService<E extends SaveEntity<ID>, ID> {

    @Autowired
    private CrudRepository<E, ID> repository;

    public CrudRepository<E, ID> getRepository() {
        return repository;
    }

    @Cacheable(cacheNames = "entities", key = "#root.targetClass.name" + '.' + "#root.method.name") // Para todoos os findAll irá fazer o cache
    public List<E> findAll(){
        return repository.findAll();
    }

    public E findById(ID id){
        return repository.findById(id).orElse(null);
    }

    @CacheEvict(cacheNames = "entities", allEntries = true) // Ao executar o método irá remover o cache de nome entities
    public E createOrUpdateEntity(ID id, E entity){
        entity.setId(id);
        return createOrUpdateEntity(entity);
    }

    @CacheEvict(cacheNames = "entities", allEntries = true)
    public E createOrUpdateEntity(E entity){
        return repository.save(entity);
    }

    @CacheEvict(cacheNames = "entities", allEntries = true)
    public void deleteEntity(ID id){
        repository.deleteById(id);
    }
}
