package com.superhero.guard.entity;

import com.superhero.guard.entity.enums.AssociationName;
import com.superhero.guard.entity.enums.PowerName;
import com.superhero.guard.entity.enums.WeaponName;

import java.util.Arrays;
import java.util.Date;

public class SuperheroFactory {


    public static Superhero createTestSuperhero() {
        Power power1 = new Power( PowerName.FLIGHT);
        Power power2 = new Power( PowerName.GENIUS_INTELLIGENCE);
        Weapon weapon1 = new Weapon(WeaponName.ARC_REACTOR);
        Weapon weapon2 = new Weapon(WeaponName.IRON_LEGION);
        Association association1 = new Association(AssociationName.AVENGERS);
        Association association2 = new Association(AssociationName.JARVIS);

        return new Superhero(
                new Date(),
                new Date(),
                "Wonder Woman",
                "Diana Prince",
                "Amazonian princess",
                Arrays.asList(power1, power2),
                Arrays.asList(weapon1, weapon2),
                Arrays.asList(association1, association2)
        );
    }
}
