package org.bedu.postwork_8.dto.visita;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import org.bedu.postwork_8.dto.cliente.CreateClienteDTO;

import java.time.LocalDateTime;

@Data
@Builder
public class Visita {

    @PositiveOrZero(message = "El identificador de la visita no puede ser un número negativo.")
    private long id;

    @NotNull(message = "La visita debe haberse realizado a algún cliente.")
    private CreateClienteDTO createClienteDTO;

    @Future(message = "La fecha de la cita no puede ser en una fecha en el pasado.")
    private LocalDateTime fechaProgramada;

    @NotEmpty(message = "La dirección no puede estar en blanco.")
    @Size(min = 10, message = "La dirección debe tener al menos 10 letras.")
    private String direccion;

    @NotEmpty(message = "El propósito de la visita no puede estar en blanco.")
    @Size(min = 15, message = "El propósito de la visita debe tener al menos 15 letras.")
    private String proposito;

    @NotEmpty(message = "El nombre del vendedor no puede estar en blanco.")
    @Size(min = 4, max = 30, message = "El nombre del vendedor debe tener entre 4 y 30 letras.")
    private String vendedor;
}
