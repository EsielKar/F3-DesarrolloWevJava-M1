package org.bedu.postwork_8.mappers;

import org.bedu.postwork_8.entities.Etapa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EtapaMapper {

    Etapa etapaModelToEtapaEntity(Etapa etapaModel);

    Etapa etapaEntityToEtapaModel(Etapa etapa);
}
