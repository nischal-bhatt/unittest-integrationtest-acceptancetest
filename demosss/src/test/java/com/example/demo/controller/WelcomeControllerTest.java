package com.example.demo.controller;

import com.example.demo.services.WelcomeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class WelcomeControllerTest {

    @Test
    //this is a simple unit test.. coz
    //its testing just the method,
    //and nothing else
    void welcome() {
        WelcomeService ws = Mockito.mock(WelcomeService.class);

        when(ws.getWelcomeMessage("John")).thenReturn("Welcome John");

        WelcomeController welcomeController =
                new WelcomeController(ws);

        assertEquals("Welcome John",welcomeController.welcome("John"));
    }
}