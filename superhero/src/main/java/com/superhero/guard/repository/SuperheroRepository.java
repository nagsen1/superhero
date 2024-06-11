package com.superhero.guard.repository;

import com.superhero.guard.entity.Superhero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SuperheroRepository extends JpaRepository<Superhero, Long> {

}
