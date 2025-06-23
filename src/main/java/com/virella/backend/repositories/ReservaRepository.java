package com.virella.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.virella.backend.entities.Reserva;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    
    //Obtener reservas por usuario
    @Query("SELECT r FROM Reserva r WHERE r.usuario.id = :idUsuario")
    List<Reserva> findByUsuarioId(@Param("idUsuario") Long idUsuario);

    //Obtener reservas por espacio de evento
    @Query("SELECT r FROM Reserva r WHERE r.espacio.id = :idEspacioEvento")
    List<Reserva> findByEspacioEventoId(@Param("idEspacioEvento") Long idEspacioEvento);

    // Obtener reservas por plan
    @Query("SELECT r FROM Reserva r WHERE r.plan.id = :idPlan")
    List<Reserva> findByPlanId(@Param("idPlan") Long idPlan);
}
