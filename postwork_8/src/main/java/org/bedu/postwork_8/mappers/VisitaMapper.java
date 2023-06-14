package org.bedu.postwork_8.mappers;

import org.bedu.postwork_8.entities.Visita;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VisitaMapper {
    Visita visitaModelToVisitaEntity(Visita visitaModel);

    Visita visitaEntityToVisitaModel(Visita visita);
}
