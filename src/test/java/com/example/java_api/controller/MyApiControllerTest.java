package com.example.java_api.controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.controllers.MyApiController;

@WebMvcTest(MyApiController.class)
public class MyApiControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnPong() throws Exception {
        mockMvc.perform(get("/api/ping"))
                .andExpect(status().isOk()) // Verifica que el estado HTTP es 200
                .andExpect(content().string("pong")); // Verifica que la respuesta es "pong"
    }
}
