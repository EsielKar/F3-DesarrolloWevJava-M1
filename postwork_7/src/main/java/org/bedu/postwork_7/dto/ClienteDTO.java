package org.bedu.postwork_7.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteDTO {
    private Long id;
    private String nombre;
    private String correo;
    private Integer empleados;
    private String direccion;
}
