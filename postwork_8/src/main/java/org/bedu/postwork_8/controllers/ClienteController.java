package org.bedu.postwork_8.controllers;

import jakarta.validation.Valid;
import org.bedu.postwork_8.dto.ClienteDTO;
import org.bedu.postwork_8.dto.cliente.CreateClienteDTO;
import org.bedu.postwork_8.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final IClienteService iClienteService;

    @Autowired
    public ClienteController(IClienteService iClienteService) {
        this.iClienteService = iClienteService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDTO save(@Valid @RequestBody CreateClienteDTO data) {
        return iClienteService.save(data);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClienteDTO> findAll() {
        return iClienteService.findAll();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<ClienteDTO> findById(@PathVariable("id") long id) {
        return iClienteService.findById(id);
    }


    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody CreateClienteDTO data, @PathVariable("id") long id){
        iClienteService.update(id, data);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id){
        iClienteService.delete(id);
    }
}
