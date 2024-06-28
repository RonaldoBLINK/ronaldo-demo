package com.ronaldo.prueba.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MovimientoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void registrarMovimientoTest() throws Exception {
        String movimientoJson = "{\"fecha\": \"2024-06-26T10:15:30\", \"tipoMovimiento\": \"deposito\", \"valor\": 100.0, \"saldo\": 100.0}";

        mockMvc.perform(post("/movimientos?cuentaId=1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(movimientoJson))
                .andExpect(status().isOk());
    }

    @Test
    public void obtenerMovimientosPorCuentaTest() throws Exception {
        mockMvc.perform(get("/movimientos?cuentaId=1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }


}
