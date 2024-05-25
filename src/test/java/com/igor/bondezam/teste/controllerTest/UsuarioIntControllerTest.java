package com.igor.bondezam.teste.controllerTest;

import com.igor.bondezam.teste.domain.Usuario;
import com.igor.bondezam.teste.fixture.UsuarioFixture;
import com.igor.bondezam.teste.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
public class UsuarioIntControllerTest extends ConfigControllerIntTest{

    @Autowired
    private UsuarioRepository repository;

    @BeforeEach
    public void setUp(){
        repository.save(UsuarioFixture.createUsuario(null));
    }

    @Test
    public void getAllControllerTest() throws Exception {
        Usuario usuario = UsuarioFixture.createUsuario(1L);

        mvc.perform(get("/usuario")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()", is(1)))
                .andExpect(jsonPath("$[0].name", is(usuario.getName())))
                .andExpect(jsonPath("$[0].email", is(usuario.getEmail())))
                .andExpect(jsonPath("$[0].cpf", is(usuario.getCpf())));
    }

    @Test
    public void getByIdControllerTest() throws Exception {
        Usuario usuario = UsuarioFixture.createUsuario(1L);

        mvc.perform(get("/usuario/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is(usuario.getName())))
                .andExpect(jsonPath("$.email", is(usuario.getEmail())))
                .andExpect(jsonPath("$.cpf", is(usuario.getCpf())));
    }

    @Test
    public void createControllerTest() throws Exception {
        Usuario usuario = UsuarioFixture.createUsuario(null);
        String usuarioJson = objectMapper.writeValueAsString(usuario);
        mvc.perform(post("/usuario")
                .contentType(MediaType.APPLICATION_JSON)
                .content(usuarioJson)
                .characterEncoding("utf-8"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", is(usuario.getName())))
                .andExpect(jsonPath("$.email", is(usuario.getEmail())))
                .andExpect(jsonPath("$.cpf", is(usuario.getCpf())));
    }

    @Test
    public void updateControllerTest() throws Exception {
        Usuario usuario = UsuarioFixture.createUsuario(1L);
        usuario.setCpf("53477795865");
        String usuarioJson = objectMapper.writeValueAsString(usuario);
        mvc.perform(put("/usuario/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(usuarioJson)
                        .characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(usuario.getName())))
                .andExpect(jsonPath("$.email", is(usuario.getEmail())))
                .andExpect(jsonPath("$.cpf", is(usuario.getCpf())))
                .andExpect(jsonPath("$.cpf", not("22569844195")));
    }

    @Test
    public void deleteControllerTest() throws Exception {
        mvc.perform(delete("/usuario/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}
