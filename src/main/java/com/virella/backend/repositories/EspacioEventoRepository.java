package com.virella.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virella.backend.entities.EspacioEvento;

public interface EspacioEventoRepository extends JpaRepository<EspacioEvento, Long> {
}
