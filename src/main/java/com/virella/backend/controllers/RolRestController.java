package com.virella.backend.controllers;

import com.virella.backend.entities.Rol;
import com.virella.backend.services.RolService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RolRestController {

    private final RolService rolService;

    // Crear Rol
    @PostMapping("/agregar")
    public ResponseEntity<Rol> createRol(@RequestBody Rol rol) {
        Rol newRol = rolService.createRol(rol);
        return new ResponseEntity<>(newRol, HttpStatus.CREATED);
    }

    // Obtener Rol por ID
    @GetMapping("/{id}")
    public ResponseEntity<Rol> getRolById(@PathVariable Long id) {
        Optional<Rol> rol = rolService.getRolById(id);
        return rol.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Obtener todos los Roles
    @GetMapping
    public ResponseEntity<List<Rol>> getAllRoles() {
        List<Rol> roles = rolService.getAllRoles();
        return ResponseEntity.ok(roles);
    }

    // Actualizar Rol
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Rol> updateRol(@PathVariable Long id, @RequestBody Rol rolDetails) {
        Rol updatedRol = rolService.updateRol(id, rolDetails);
        return ResponseEntity.ok(updatedRol);
    }

    // Eliminar Rol
    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<Void> deleteRol(@PathVariable Long id) {
        rolService.deleteRol(id);
        return ResponseEntity.noContent().build();
    }
}
