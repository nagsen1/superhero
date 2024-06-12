package com.superhero.guard.entity;

import com.superhero.guard.entity.enums.PowerName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table (name = "power")
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Power {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "power_name")
    private PowerName powerName;

    public Power(PowerName powerName) {
        this.powerName = powerName;
    }
}
