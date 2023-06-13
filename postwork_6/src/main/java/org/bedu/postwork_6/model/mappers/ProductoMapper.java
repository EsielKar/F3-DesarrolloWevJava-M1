package org.bedu.postwork_6.model.mappers;

import org.bedu.postwork_6.persistence.entities.Producto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
    Producto productoModelToProductoEntity(org.bedu.postwork_6.model.Producto productoModel);

    org.bedu.postwork_6.model.Producto productoEntityToProductoModel(Producto producto);
}
