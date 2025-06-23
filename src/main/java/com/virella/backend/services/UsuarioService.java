package com.virella.backend.services;

import com.virella.backend.entities.Rol;
import com.virella.backend.entities.Usuario;
import com.virella.backend.repositories.RolRepository;
import com.virella.backend.repositories.UsuarioRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;

    // Crear Usuario
    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Buscar Usuario por ID
    public Optional<Usuario> getUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    // Obtener todos los Usuarios
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    // Actualizar Usuario
    public Usuario updateUsuario(Long id, Usuario usuarioDetails) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setUsuario(usuarioDetails.getUsuario());
        usuario.setCorreo(usuarioDetails.getCorreo());
        usuario.setContraseña(usuarioDetails.getContraseña());
        return usuarioRepository.save(usuario);
    }

    // Eliminar Usuario
    public void deleteUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuarioRepository.delete(usuario);
    }

    
    public Usuario crearUsuarioConRol(Usuario usuario, Long idRol) {
        Optional<Rol> rolOpt = rolRepository.findById(idRol);
        if (rolOpt.isEmpty()) {
            throw new RuntimeException("Rol no encontrado con id: " + idRol);
        }
        usuario.setRol(rolOpt.get());
        return usuarioRepository.save(usuario);
    }
}
