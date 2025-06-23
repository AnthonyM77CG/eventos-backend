package com.virella.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virella.backend.entities.Pago;

import java.util.List;

public interface PagoRepository extends JpaRepository<Pago, Long> {
    List<Pago> findByReservaId(Long idReserva);
}
