package org.bedu.postwork_7.services;

import org.bedu.postwork_7.dto.ClienteDTO;
import org.bedu.postwork_7.dto.cliente.CreateClienteDTO;

import java.util.List;
import java.util.Optional;

public interface IClienteService {

    ClienteDTO save(CreateClienteDTO data);
    List<ClienteDTO> findAll();
    Optional<ClienteDTO> findById(long id);
    void delete(long id);
    void update(long id, CreateClienteDTO data);
}
