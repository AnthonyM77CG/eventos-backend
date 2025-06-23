package com.virella.backend.services;

import com.virella.backend.entities.Reserva;
import com.virella.backend.entities.Usuario;
import com.virella.backend.repositories.PagoRepository;
import com.virella.backend.repositories.ReservaRepository;
import com.virella.backend.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final PagoRepository pagoRepository;
    private final UsuarioRepository usuarioRepository;

    // Crear Reserva
    public Reserva createReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    //JPQL - Obtener reservas por usuario
    public List<Reserva> getReservasByUsuarioId(Long idUsuario) {
        return reservaRepository.findByUsuarioId(idUsuario);
    }

    //JPQL - Obtener reservas por espacio de evento
    public List<Reserva> getReservasByEspacioEventoId(Long idEspacioEvento) {
        return reservaRepository.findByEspacioEventoId(idEspacioEvento);
    }

    //JPQL - Obtener reservas por plan
    public List<Reserva> getReservasByPlanId(Long idPlan) {
        return reservaRepository.findByPlanId(idPlan);
    }

    //Cambiar usuario de reserva
    public Reserva cambiarUsuarioDeReserva(Long idReserva, Long idUsuario) {
        Optional<Reserva> reservaOpt = reservaRepository.findById(idReserva);
        if (reservaOpt.isEmpty()) {
            throw new RuntimeException("Reserva no encontrada con id: " + idReserva);
        }
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(idUsuario);
        if (usuarioOpt.isEmpty()) {
            throw new RuntimeException("Usuario no encontrado con id: " + idUsuario);
        }
        Reserva reserva = reservaOpt.get();
        Usuario usuario = usuarioOpt.get();
        reserva.setUsuario(usuario);
        return reservaRepository.save(reserva);
    }


    // Buscar Reserva por ID
    public Optional<Reserva> getReservaById(Long id) {
        return reservaRepository.findById(id);
    }

    // Obtener todas las Reservas
    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
    }

    // Actualizar Reserva
    public Reserva updateReserva(Long id, Reserva reservaDetails) {
        Reserva reserva = reservaRepository.findById(id).orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
        reserva.setFecha(reservaDetails.getFecha());
        reserva.setHoraInicio(reservaDetails.getHoraInicio());
        reserva.setHoraFin(reservaDetails.getHoraFin());
        reserva.setEstado(reservaDetails.getEstado());
        return reservaRepository.save(reserva);
    }

    // Eliminar Reserva
    public void deleteReserva(Long id) {
        Reserva reserva = reservaRepository.findById(id).orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
        reservaRepository.delete(reserva);
    }

    //Transaccion
    @Transactional
    public void eliminarReservaYPago(Long reservaId) {
        try {
            Reserva reserva = reservaRepository.findById(reservaId)
                    .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));

            pagoRepository.delete(reserva.getPago());

            reservaRepository.delete(reserva);

        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar reserva y pago: " + e.getMessage());
        }
    }


}
