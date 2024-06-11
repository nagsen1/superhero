package com.superhero.guard.api;

import com.superhero.guard.entity.Superhero;
import com.superhero.guard.services.SuperheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/superhero")
public class SuperheroController {

    private final SuperheroService superheroService;

    @Autowired
    public SuperheroController(SuperheroService superheroService) {
        this.superheroService = superheroService;
    }

    @PostMapping
    public ResponseEntity<Superhero> save(@RequestBody Superhero entity) {
        Superhero savedEntity = superheroService.save(entity);
        return ResponseEntity.ok(savedEntity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Superhero> findById(@PathVariable Long id) {
        Optional<Superhero> entity = superheroService.findById(id);
        return entity.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Superhero>> findAll() {
        List<Superhero> entities = superheroService.findAll();
        return ResponseEntity.ok(entities);
    }
}
