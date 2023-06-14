package org.bedu.postwork_7.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "ETAPAS")
@Entity
@NoArgsConstructor
public class Etapa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long etapaId;

    private String nombre;

    @Column(unique = true, nullable = false)
    private Integer orden;
}
