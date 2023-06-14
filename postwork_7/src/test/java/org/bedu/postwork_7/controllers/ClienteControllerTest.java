package org.bedu.postwork_7.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bedu.postwork_7.dto.ClienteDTO;
import org.bedu.postwork_7.dto.cliente.CreateClienteDTO;
import org.bedu.postwork_7.entities.Cliente;
import org.bedu.postwork_7.services.IClienteService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyLong;


import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(ClienteController.class)
class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IClienteService clienteService;

    @Test
    @DisplayName("createCliente")
    void save() throws Exception {

        CreateClienteDTO createClienteDTO = CreateClienteDTO.builder()
                .nombre("Luis hernandez")
                .correo("luis@gmail.com")
                .empleados(10)
                .direccion("CDMX")
                .build();

        ClienteDTO clienteDTO = ClienteDTO.builder()
                .id(5L)
                .nombre("Luis hernandez")
                .correo("luis@gmail.com")
                .empleados(10)
                .direccion("CDMX")
                .build();

        given(clienteService.save(createClienteDTO)).willReturn(clienteDTO);
        mockMvc.perform(post("/cliente")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(createClienteDTO)))
                .andExpect(status().isCreated());

    }

    @Test
    @DisplayName("getClientes")
    void findAll() throws Exception {
        List<ClienteDTO> list = Arrays.asList(
                ClienteDTO.builder().id(1L).nombre("Nombre 1").correo("correo1@gmail.com").empleados(4).direccion("Direccion 1").build(),
                ClienteDTO.builder().id(2L).nombre("Nombre 2").correo("correo2@gmail.com").empleados(5).direccion("Direccion 2").build(),
                ClienteDTO.builder().id(3L).nombre("Nombre 3").correo("correo3@gmail.com").empleados(6).direccion("Direccion 3").build()
        );

        given(clienteService.findAll()).willReturn(list);

        mockMvc.perform(get("/cliente")
                        .content(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[2].id", is(3)))
                .andExpect(jsonPath("$[0].nombre", is("Nombre 1")))
                .andExpect(jsonPath("$[1].nombre", is("Nombre 2")))
                .andExpect(jsonPath("$[2].nombre", is("Nombre 3")))
                .andExpect(jsonPath("$[0].correo", is("correo1@gmail.com")))
                .andExpect(jsonPath("$[1].correo", is("correo2@gmail.com")))
                .andExpect(jsonPath("$[2].correo", is("correo3@gmail.com")))
                .andExpect(jsonPath("$[0].empleados", is(4)))
                .andExpect(jsonPath("$[1].empleados", is(5)))
                .andExpect(jsonPath("$[2].empleados", is(6)))
                .andExpect(jsonPath("$[0].direccion", is("Direccion 1")))
                .andExpect(jsonPath("$[1].direccion", is("Direccion 2")))
                .andExpect(jsonPath("$[2].direccion", is("Direccion 3")));

    }

    @Test
    @DisplayName("getCliente")
    void findById() throws Exception {

        given(clienteService.findById(anyLong())).willReturn(Optional.of(
                ClienteDTO.builder()
                        .id(5L)
                        .nombre("Roberto")
                        .correo("roberto@gmail.com")
                        .empleados(5)
                        .direccion("Ciudad de México").build()));

        mockMvc.perform(get("/cliente/5")
                        .content(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(5)))
                .andExpect(jsonPath("$.nombre", is("Roberto")))
                .andExpect(jsonPath("$.correo", is("roberto@gmail.com")))
                .andExpect(jsonPath("$.empleados", is(5)))
                .andExpect(jsonPath("$.direccion", is("Ciudad de México")));

    }

    @Test
    @DisplayName("updateCliente")
    void update() throws Exception{

        CreateClienteDTO createClienteDTO = CreateClienteDTO.builder()
                .nombre("Gerardo")
                .correo("luis@gmail.com")
                .empleados(10)
                .direccion("CDMX")
                .build();


        mockMvc.perform(put("/cliente/5")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(createClienteDTO)))
                .andExpect(status().isNoContent());

    }

    @Test
    void delete() throws Exception {
        doNothing().when(clienteService).delete(anyLong());
        clienteService.delete(1L);
        verify(clienteService, times(1)).delete(1L);
    }
}