package com.virella.backend.services;

import com.virella.backend.entities.Tarifa;
import com.virella.backend.repositories.TarifaRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TarifaService {

    private final TarifaRepository tarifaRepository;

    // Crear Tarifa
    public Tarifa createTarifa(Tarifa tarifa) {
        return tarifaRepository.save(tarifa);
    }

    // Buscar Tarifa por ID
    public Optional<Tarifa> getTarifaById(Long id) {
        return tarifaRepository.findById(id);
    }

    // Obtener todas las Tarifas
    public List<Tarifa> getAllTarifas() {
        return tarifaRepository.findAll();
    }

    // Actualizar Tarifa
    public Tarifa updateTarifa(Long id, Tarifa tarifaDetails) {
        Tarifa tarifa = tarifaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarifa no encontrada"));
        tarifa.setPrecio(tarifaDetails.getPrecio());
        return tarifaRepository.save(tarifa);
    }

    // Eliminar Tarifa
    public void deleteTarifa(Long id) {
        Tarifa tarifa = tarifaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarifa no encontrada"));
        tarifaRepository.delete(tarifa);
    }
}
