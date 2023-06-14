package org.bedu.postwork_8.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bedu.postwork_8.dto.ClienteDTO;
import org.bedu.postwork_8.dto.cliente.CreateClienteDTO;
import org.bedu.postwork_8.services.IClienteService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyLong;

@WebMvcTest(ClienteController.class)
@AutoConfigureRestDocs
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
        mockMvc.perform(RestDocumentationRequestBuilders.post("/cliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(createClienteDTO)))
                .andExpect(status().isCreated())
                .andDo(document("cliente/post-cliente",
                        requestFields(
                                fieldWithPath("id").description("identificador del cliente"),
                                fieldWithPath("nombre").description("nombre del cliente"),
                                fieldWithPath("correo").description("correo de contacto del cliente"),
                                fieldWithPath("empleados").description("número de trabajadores del cliente"),
                                fieldWithPath("direccion").description("domicilio del cliente")
                        )));
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

        mockMvc.perform(RestDocumentationRequestBuilders.get("/cliente")
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
                .andExpect(jsonPath("$[2].direccion", is("Direccion 3")))
                .andDo(document("cliente/get-clientes",
                        responseFields(
                                fieldWithPath("[].id").description("identificador del cliente"),
                                fieldWithPath("[].nombre").description("nombre del cliente"),
                                fieldWithPath("[].correo").description("correo de contacto del cliente"),
                                fieldWithPath("[].empleados").description("número de trabajadores del cliente"),
                                fieldWithPath("[].direccion").description("domicilio del cliente")
                        )));


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

        mockMvc.perform(RestDocumentationRequestBuilders.get("/cliente/{id}",5L)
                        .content(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(5)))
                .andExpect(jsonPath("$.nombre", is("Roberto")))
                .andExpect(jsonPath("$.correo", is("roberto@gmail.com")))
                .andExpect(jsonPath("$.empleados", is(5)))
                .andExpect(jsonPath("$.direccion", is("Ciudad de México")))
                .andDo(document("cliente/get-cliente",
                        pathParameters(
                                parameterWithName("id").description("Identificador del cliente")
                        ),
                        responseFields(
                                fieldWithPath("id").description("identificador del cliente"),
                                fieldWithPath("nombre").description("nombre del cliente"),
                                fieldWithPath("correo").description("correo de contacto del cliente"),
                                fieldWithPath("empleados").description("número de trabajadores del cliente"),
                                fieldWithPath("direccion").description("domicilio del cliente")

                        )));

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


        mockMvc.perform(RestDocumentationRequestBuilders.put("/cliente/{id}",1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(createClienteDTO)))
                .andExpect(status().isNoContent())
                .andDo(document("cliente/put-cliente",
                        pathParameters(
                                parameterWithName("id").description("Identificador del cliente")
                        ),
                        requestFields(
                                fieldWithPath("id").description("El identificador del nuevo cliente"),
                                fieldWithPath("nombre").description("El nombre del cliente"),
                                fieldWithPath("direccion").description("La dirección del cliente"),
                                fieldWithPath("correo").description("La dirección de correo electrónico de contacto"),
                                fieldWithPath("empleados").description("El número de personas que trabajan en las oficinas e cliente")
                        )
                ));

    }

    @Test
    void delete() throws Exception {
        mockMvc.perform(RestDocumentationRequestBuilders.delete("/cliente/{id}", 1)
                        .content(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isNoContent())

                .andDo(document("cliente/delete-cliente",
                        pathParameters(
                                parameterWithName("id").description("Identificador del cliente")
                        )));
    }
}