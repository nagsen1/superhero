package com.superhero.guard.entity;

import com.superhero.guard.entity.enums.AssociationName;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Table (name = "association")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Association implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column
    private AssociationName associationName;

    @ManyToOne(fetch = FetchType.LAZY, cascade = ALL, targetEntity = Superhero.class)
    @JoinColumn(name = "superhero_id")
    private Superhero superhero;
}
