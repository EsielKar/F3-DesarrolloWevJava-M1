package org.bedu.postwork_8.services.Impl;

import org.bedu.postwork_8.dto.ClienteDTO;
import org.bedu.postwork_8.dto.cliente.CreateClienteDTO;
import org.bedu.postwork_8.entities.Cliente;
import org.bedu.postwork_8.mappers.ClienteMapper;
import org.bedu.postwork_8.repositories.ClienteRepository;
import org.bedu.postwork_8.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ImplClienteService implements IClienteService {

    private ClienteRepository clienteRepository;
    private ClienteMapper clienteMapper;

    @Autowired

    public ImplClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }


    @Override
    public ClienteDTO save(CreateClienteDTO data) {
        Cliente entity = clienteRepository.save(clienteMapper.toClienteModel(data));
        return clienteMapper.toClienteDTO(entity);
    }

    @Override
    public List<ClienteDTO> findAll() {
        List<Cliente> cliente = clienteRepository.findAll();
        return cliente.stream().map(clienteMapper::toClienteDTO).toList();
    }

    @Override
    public Optional<ClienteDTO> findById(long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El cliente especificado no existe");
        }
        return cliente.map(value -> Optional.of(clienteMapper.toClienteDTO(value))).orElse(Optional.empty());
    }

    @Override
    public void delete(long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public void update(long id, CreateClienteDTO data) {
        Optional<Cliente> actual = clienteRepository.findById(id);
        if(actual.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El cliente especificado no existe");
        }

        Cliente cliente = actual.get();
        clienteMapper.toClienteModel(cliente,data);
        clienteRepository.save(cliente);
    }


}
