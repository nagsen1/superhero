package com.superhero.guard;

import com.superhero.guard.entity.Superhero;
import com.superhero.guard.entity.SuperheroFactory;
import com.superhero.guard.repository.SuperheroRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.annotation.Rollback;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SuperheroApplicationTests {

    @Autowired
    SuperheroRepository superheroRepository;

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15-alpine");

    @BeforeAll
    static void startContainer() {
        postgres.start();
    }

    @AfterAll
    static void stopContainer() {
        postgres.stop();
    }

    @Test
    @Order(1)
    void connectionEstablished(){
        assertThat(postgres.isCreated()).isTrue();
        assertThat(postgres.isRunning()).isTrue();
    }

    @Test
    @Order(2)
    @Rollback(value = false)
    void testSuperheroCreation() {
        Superhero testSuperhero = SuperheroFactory.createTestSuperhero();
        Superhero result = superheroRepository.save(testSuperhero);
        assertNotNull(result);
        assertEquals(testSuperhero,result);

    }

    @Test
    @Order(3)
    @Rollback(value = false)
    void getSuperhero(){
        Superhero superhero = superheroRepository.findById(1L).get();
        assertNotNull(superhero);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    void getSuperheroList(){
        List<Superhero> superheroList = superheroRepository.findAll();
        assertNotNull(superheroList);
        assertThat(superheroList.size()).isGreaterThan(0);
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    void deleteSuperhero(){
        Superhero superhero = superheroRepository.findById(1L).get();
        superheroRepository.delete(superhero);

        Superhero superhero1 = null;
        Optional<Superhero> optionalSuperhero = superheroRepository.findByAlias("Wonder Woman");

        if (optionalSuperhero.isPresent()){
            superhero1 = optionalSuperhero.get();
        }

        assertThat(superhero1).isNull();
    }

}
