package org.bedu.postwork_7.mappers;

import org.bedu.postwork_7.entities.Producto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
    Producto productoModelToProductoEntity(Producto productoModel);

    Producto productoEntityToProductoModel(Producto producto);
}
