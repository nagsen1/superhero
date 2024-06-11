package com.superhero.guard.entity;

import com.superhero.guard.entity.enums.PowerName;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Table (name = "power")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Power implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "power_name")
    private PowerName powerName;

    @ManyToOne(fetch = FetchType.LAZY, cascade = ALL, targetEntity = Superhero.class)
    @JoinColumn(name = "superhero_id")
    private Superhero superhero;
}
