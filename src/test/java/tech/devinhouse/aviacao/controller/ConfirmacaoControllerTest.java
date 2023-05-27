package tech.devinhouse.aviacao.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class ConfirmacaoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testRegistrarConfirmacao() throws Exception {
        String requestBody = "{ \\\"cpf\\\": 11111111111, \\\"assento\\\": \\\"4A\\\", \\\"malasDespachadas\\\": true }";

        mockMvc.perform(post("/api/passageiros/confirmacao")
                .contentType("application/json")
                .content(requestBody))
                .andExpect(status().isOk());
    }

}
