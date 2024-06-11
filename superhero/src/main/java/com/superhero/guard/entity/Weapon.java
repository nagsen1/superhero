package com.superhero.guard.entity;

import com.superhero.guard.entity.enums.WeaponName;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Table (name = "weapon")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Weapon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column
    private WeaponName weaponName;

    @ManyToOne(fetch = FetchType.LAZY, cascade = ALL, targetEntity = Superhero.class)
    @JoinColumn(name = "superhero_id")
    private Superhero superhero;
}
