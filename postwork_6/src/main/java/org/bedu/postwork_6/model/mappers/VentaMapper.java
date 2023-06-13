package org.bedu.postwork_6.model.mappers;

import org.bedu.postwork_6.persistence.entities.Venta;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VentaMapper {
    Venta ventaModelToVentaEntity(org.bedu.postwork_6.model.Venta ventaModel);

    org.bedu.postwork_6.model.Venta ventaEntityToVentaModel(Venta venta);
}
