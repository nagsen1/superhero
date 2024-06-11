package com.superhero.guard.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Table (name = "superhero")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Superhero implements Serializable {

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


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "superhero", cascade = ALL, targetEntity = Power.class)
    private List<Power> powers;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "superhero", cascade = ALL, targetEntity = Weapon.class)
    private List<Weapon> weapons;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "superhero", cascade = ALL, targetEntity = Association.class)
    private List<Association> associations;



}
