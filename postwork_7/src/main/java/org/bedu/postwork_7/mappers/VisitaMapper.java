package org.bedu.postwork_7.mappers;

import org.bedu.postwork_7.entities.Visita;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VisitaMapper {
    Visita visitaModelToVisitaEntity(Visita visitaModel);

    Visita visitaEntityToVisitaModel(Visita visita);
}
