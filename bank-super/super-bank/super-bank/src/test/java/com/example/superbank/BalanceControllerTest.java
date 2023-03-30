package com.example.superbank;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
class BalanceControllerTest {             //Интеграционные тесты

    @Autowired
    private MockMvc mockMvc;
    @Test
    void addMoney() {

    }
}