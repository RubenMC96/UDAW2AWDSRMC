package com.rmc.ejerciciosT6.controllerTest;

import static org.hamcrest.Matchers.*; //hasSize, instanceOf, put...
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*; //get, post, put...
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*; //jsonPath, status..

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.rmc.ejerciciosT6.controller.EmpleadoController;
import com.rmc.ejerciciosT6.domain.Empleado;
import com.rmc.ejerciciosT6.domain.Genero;
import com.rmc.ejerciciosT6.service.EmpleadoService;

@SpringBootTest
@AutoConfigureJsonTesters
@AutoConfigureMockMvc
@TestInstance(Lifecycle.PER_CLASS)
public class EmpleadoControllerTest {
    @InjectMocks
    EmpleadoController empleadoController;

    @MockBean
    EmpleadoService empleadoService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getOnElementTest() throws Exception {
        Empleado empleado = new Empleado(2L, "pepe", "pepe@gmail.com", 1000D, true, Genero.MASCULINO);
        Mockito.when(empleadoService.obtenerPorId(2L)).thenReturn(empleado);
        mockMvc.perform(get("/empleado/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email", is("pepe@gmail.com")));

    }
}
