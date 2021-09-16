package com.libary.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest
@AutoConfigureMockMvc

public class LibaryControllerTest {
    static String BOOK_API = "/libary/";
    @Autowired
    MockMvc mvc;

    @Test
    @DisplayName("Deve criar um livro com sucesso.")
    public void createLibaryTest() throws Exception {
        String json = new ObjectMapper().writeValueAsString(null);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post(BOOK_API)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);

        mvc
            .perform(request)
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(jsonPath( "id").isNotEmpty())
                .andExpect(jsonPath( "nome").value("Meu Livro"))
                .andExpect(jsonPath( "auto").value("José"))
                .andExpect(jsonPath( "quantidade").value(5))
                .andExpect(jsonPath( "preco").value(1.5));



    }


    @Test
    @DisplayName("Deve criar um erro de validação quando não houver dados suficientes para criação de livro.")
    public void createInvalidLibaryTest() throws Exception {

    }
}
