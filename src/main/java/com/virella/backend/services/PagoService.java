package com.virella.backend.services;

import com.virella.backend.entities.Pago;
import com.virella.backend.repositories.PagoRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PagoService {

    private final PagoRepository pagoRepository;

    public Pago getPagoConReserva(Long idPago) {
        return pagoRepository.findById(idPago).orElseThrow(() -> new RuntimeException("Pago no encontrado"));
    }
    
    // Crear Pago
    public Pago createPago(Pago pago) {
        return pagoRepository.save(pago);
    }

    // Buscar Pago por ID
    public Optional<Pago> getPagoById(Long id) {
        return pagoRepository.findById(id);
    }

    // Obtener todos los Pagos
    public List<Pago> getAllPagos() {
        return pagoRepository.findAll();
    }

    // Actualizar Pago
    public Pago updatePago(Long id, Pago pagoDetails) {
        Pago pago = pagoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pago no encontrado"));
        pago.setMonto(pagoDetails.getMonto());
        pago.setMetodoPago(pagoDetails.getMetodoPago());
        pago.setEstadoPago(pagoDetails.getEstadoPago());
        return pagoRepository.save(pago);
    }

    // Eliminar Pago
    public void deletePago(Long id) {
        Pago pago = pagoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pago no encontrado"));
        pagoRepository.delete(pago);
    }
}
