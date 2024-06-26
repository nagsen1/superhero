package com.superhero.guard.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "superhero")
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Superhero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "created_at")
    private Date createdAt;

    @Column (name = "updated_at")
    private Date updatedAt;

    @Column (name = "alias")
    private String alias;

    @Column (name = "name")
    private String name;

    @Column (name = "origin", columnDefinition = "TEXT")
    private String origin;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY,  cascade = ALL )
    @JoinColumn(name = "fk_superhero_id", referencedColumnName = "id")
    private List<Power> powers;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, cascade = ALL)
    @JoinColumn(name = "fk_superhero_id", referencedColumnName = "id")
    private List<Weapon> weapons;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, cascade = ALL)
    @JoinColumn(name = "fk_superhero_id", referencedColumnName = "id")
    private List<Association> associations;

    public Superhero(Date createdAt, Date updatedAt, String alias, String name, String origin, List<Power> powers, List<Weapon> weapons, List<Association> associations) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.alias = alias;
        this.name = name;
        this.origin = origin;
        this.powers = powers;
        this.weapons = weapons;
        this.associations = associations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Superhero superhero = (Superhero) o;
        return Objects.equals(id, superhero.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
