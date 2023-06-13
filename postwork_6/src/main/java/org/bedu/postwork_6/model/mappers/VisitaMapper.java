package org.bedu.postwork_6.model.mappers;

import org.bedu.postwork_6.persistence.entities.Visita;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VisitaMapper {
    Visita visitaModelToVisitaEntity(org.bedu.postwork_6.model.Visita visitaModel);

    org.bedu.postwork_6.model.Visita visitaEntityToVisitaModel(Visita visita);
}
