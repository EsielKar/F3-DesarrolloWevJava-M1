package org.bedu.postwork_8.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "clientes")
@Entity
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "correo_contacto", nullable = false)
    private String correo;

    @Column(name = "numero_empleados")
    private Integer empleados;

    @Column
    private String direccion;
}
