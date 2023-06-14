package org.bedu.postwork_8.mappers;

import org.bedu.postwork_8.dto.ClienteDTO;
import org.bedu.postwork_8.dto.cliente.CreateClienteDTO;
import org.bedu.postwork_8.entities.Cliente;
import org.mapstruct.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ClienteMapper {

    @Mapping(target = "id", ignore = true)
    Cliente toClienteModel (CreateClienteDTO data);

    ClienteDTO toClienteDTO (Cliente data);

    @Mapping(target = "id", ignore = true)
    void toClienteModel (@MappingTarget Cliente entity, CreateClienteDTO data);
}
