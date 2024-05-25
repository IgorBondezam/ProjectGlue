package com.igor.bondezam.teste.controllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.igor.bondezam.teste.TesteApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = TesteApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-test.yaml")
@ActiveProfiles("test")
public abstract class ConfigControllerIntTest {

    @Autowired
    public MockMvc mvc;

    @Autowired
    public ObjectMapper objectMapper;

}