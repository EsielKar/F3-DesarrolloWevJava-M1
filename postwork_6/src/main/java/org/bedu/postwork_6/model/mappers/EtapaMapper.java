package org.bedu.postwork_6.model.mappers;

import org.bedu.postwork_6.persistence.entities.Etapa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EtapaMapper {

    Etapa etapaModelToEtapaEntity(org.bedu.postwork_6.model.Etapa etapaModel);

    org.bedu.postwork_6.model.Etapa etapaEntityToEtapaModel(Etapa etapa);
}
