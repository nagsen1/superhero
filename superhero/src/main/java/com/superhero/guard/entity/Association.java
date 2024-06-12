package com.superhero.guard.entity;

import com.superhero.guard.entity.enums.AssociationName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table (name = "association")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Association {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column
    private AssociationName associationName;

    public Association(AssociationName associationName) {
        this.associationName = associationName;
    }
}
