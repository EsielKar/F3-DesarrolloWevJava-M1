package org.bedu.postwork_7.dto.cliente;

import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
public class CreateClienteDTO {

    private Long id;

    @NotBlank(message = "El nombre del cliente no puede estar vacío")
    @Length(min = 5, max = 30, message = "El nombre del cliente debe tener al menos 5 letras y ser menor a 30")
    private String nombre;

    @Email
    private String correo;

    @Min(value = 10, message = "Los clientes con menos de {value} empleados no son válidos")
    @Max(value = 10000, message = "Los clientes con más de {value} empleados no son válidos")
    private Integer empleados;

    @NotBlank(message = "Se debe proporcionar una dirección")
    private String direccion;
}
