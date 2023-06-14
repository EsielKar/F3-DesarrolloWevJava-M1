package org.bedu.postwork_8.dto.venta;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import org.bedu.postwork_8.dto.cliente.CreateClienteDTO;
import org.bedu.postwork_8.dto.producto.Producto;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class Venta {

    @PositiveOrZero(message = "El identificador de la venta no puede ser un número negativo")
    private long ventaId;

    @DecimalMin(value = "1.00", inclusive = true, message = "La venta debe ser de al menos 1.00")
    private float monto;

    @NotEmpty(message = "La venta debe tener por lo menos un producto.")
    private List<Producto> productos;

    @NotNull(message = "La venta debe haberse realizado a algún cliente.")
    private CreateClienteDTO createClienteDTO;

    @PastOrPresent(message = "La venta no puede ocurrir en el futuro.")
    private LocalDateTime fechaCreacion;
}
