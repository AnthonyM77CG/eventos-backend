package com.virella.backend.controllers;

import com.virella.backend.entities.EspacioEvento;
import com.virella.backend.services.EspacioEventoService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/espacios_evento")
@RequiredArgsConstructor
public class EspacioEventoRestController {

    private final EspacioEventoService espacioEventoService;

    // Crear Espacio de Evento
    @PostMapping("/agregar")
    public ResponseEntity<EspacioEvento> createEspacioEvento(@RequestBody EspacioEvento espacioEvento) {
        EspacioEvento newEspacio = espacioEventoService.createEspacioEvento(espacioEvento);
        return new ResponseEntity<>(newEspacio, HttpStatus.CREATED);
    }

    // Obtener Espacio de Evento por ID
    @GetMapping("/{id}")
    public ResponseEntity<EspacioEvento> getEspacioEventoById(@PathVariable Long id) {
        Optional<EspacioEvento> espacio = espacioEventoService.getEspacioEventoById(id);
        return espacio.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Obtener todos los Espacios de Evento
    @GetMapping
    public ResponseEntity<List<EspacioEvento>> getAllEspaciosEvento() {
        List<EspacioEvento> espacios = espacioEventoService.getAllEspaciosEvento();
        return ResponseEntity.ok(espacios);
    }

    // Actualizar Espacio de Evento
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<EspacioEvento> updateEspacioEvento(@PathVariable Long id, @RequestBody EspacioEvento espacioEventoDetails) {
        EspacioEvento updatedEspacio = espacioEventoService.updateEspacioEvento(id, espacioEventoDetails);
        return ResponseEntity.ok(updatedEspacio);
    }

    // Eliminar Espacio de Evento
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deleteEspacioEvento(@PathVariable Long id) {
        espacioEventoService.deleteEspacioEvento(id);
        return ResponseEntity.noContent().build();
    }
}
