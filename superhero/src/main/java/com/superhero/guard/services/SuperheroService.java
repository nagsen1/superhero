package com.superhero.guard.services;

import com.superhero.guard.entity.Superhero;
import com.superhero.guard.repository.SuperheroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuperheroService {

    private final SuperheroRepository superheroRepository;


    @Autowired
    public SuperheroService(SuperheroRepository superheroRepository) {
        this.superheroRepository = superheroRepository;
    }

    public Superhero save(Superhero entity) {
        return superheroRepository.save(entity);
    }

    public Optional<Superhero> findById(Long id) {
        return superheroRepository.findById(id);
    }

    public List<Superhero> findAll() {
        return superheroRepository.findAll();
    }

    public void deleteById(Long id){
        superheroRepository.deleteById(id);
    }
}
