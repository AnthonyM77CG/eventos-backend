package com.virella.backend.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Collections;
import java.util.Optional;

import com.virella.backend.entities.Usuario;
import com.virella.backend.services.UsuarioService;

public class UsuarioRestControllerTest {
    @Mock
    private UsuarioService usuarioService;

    @InjectMocks
    private UsuarioRestController usuarioRestController;
    
    private MockMvc mockMvc;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(usuarioRestController).build();
    }
    
    @Test
    void testGetUsuarioById() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        when(usuarioService.getUsuarioById(1L)).thenReturn(Optional.of(usuario));
        mockMvc.perform(get("/api/usuarios/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    void testGetAllUsuarios() throws Exception {
        when(usuarioService.getAllUsuarios()).thenReturn(Collections.emptyList());
        mockMvc.perform(get("/api/usuarios"))
                .andExpect(status().isOk());
    }


    @Test
    void testDeleteUsuario() throws Exception {
        mockMvc.perform(delete("/api/usuarios/eliminar/1"))
                .andExpect(status().isNoContent());
    }
}
