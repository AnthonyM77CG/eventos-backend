package com.virella.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virella.backend.entities.Tarifa;

import java.util.List;

public interface TarifaRepository extends JpaRepository<Tarifa, Long> {
    List<Tarifa> findByEspacioId(Long idEspacio);
}
