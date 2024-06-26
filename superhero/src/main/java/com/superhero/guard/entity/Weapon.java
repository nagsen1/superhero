package com.superhero.guard.entity;

import com.superhero.guard.entity.enums.WeaponName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table (name = "weapon")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Weapon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column
    private WeaponName weaponName;

    public Weapon(WeaponName weaponName) {
        this.weaponName = weaponName;
    }
}
