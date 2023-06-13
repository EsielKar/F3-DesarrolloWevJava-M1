package org.bedu.postwork_6.model.mappers;

import org.bedu.postwork_6.persistence.entities.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    Cliente clienteModelToClienteEntity(org.bedu.postwork_6.model.Cliente clienteModel);

    org.bedu.postwork_6.model.Cliente clienteEntityToClienteModel(Cliente cliente);
}
