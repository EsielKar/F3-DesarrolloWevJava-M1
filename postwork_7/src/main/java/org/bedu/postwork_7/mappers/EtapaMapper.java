package org.bedu.postwork_7.mappers;

import org.bedu.postwork_7.entities.Etapa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EtapaMapper {

    Etapa etapaModelToEtapaEntity(Etapa etapaModel);

    Etapa etapaEntityToEtapaModel(Etapa etapa);
}
