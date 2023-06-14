package org.bedu.postwork_8.mappers;

import org.bedu.postwork_8.entities.Venta;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VentaMapper {
    Venta ventaModelToVentaEntity(Venta ventaModel);

    Venta ventaEntityToVentaModel(Venta venta);
}
