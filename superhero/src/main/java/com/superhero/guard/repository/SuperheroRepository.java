package com.superhero.guard.repository;

import com.superhero.guard.entity.Superhero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface SuperheroRepository extends JpaRepository<Superhero, Long> {

    Optional<Superhero> findByAlias(String alias);

}
