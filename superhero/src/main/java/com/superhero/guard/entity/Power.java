package com.superhero.guard.entity;

import com.superhero.guard.entity.enums.PowerName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Table (name = "power")
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Power implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "power_name")
    private PowerName powerName;

    /*
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY, cascade = ALL, targetEntity = Superhero.class)
    @JoinColumn(name = "superhero_id")
    @ToString.Exclude
    private Superhero superhero; */

}
