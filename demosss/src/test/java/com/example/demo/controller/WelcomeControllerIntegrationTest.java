package com.example.demo.controller;

import com.example.demo.services.WelcomeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class WelcomeControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WelcomeService ws;

    @Test
    void shouldGetDefaultWelcomeMessage() throws Exception {

        when(ws.getWelcomeMessage("Stranger"))
                .thenReturn("Welcome Stranger!");
        mockMvc.perform(get("/welcome"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Welcome Stranger!")));

        verify(ws).getWelcomeMessage("Stranger");

    }

    @Test
    void shouldGetCustomWelcomeMessage() throws Exception {

        when(ws.getWelcomeMessage("ratlam"))
                .thenReturn("Welcome ratlam!");
        mockMvc.perform(get("/welcome?name=ratlam"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Welcome ratlam!")));

        verify(ws).getWelcomeMessage("ratlam");

    }
}