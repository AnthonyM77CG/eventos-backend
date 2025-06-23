package com.virella.backend.controllers;

import com.virella.backend.entities.Pago;
import com.virella.backend.services.PagoService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pagos")
@RequiredArgsConstructor
public class PagoRestController {

    private final PagoService pagoService;
     
    //Obtener pagos con reservas
    @GetMapping("/reserva/{id}")
    public ResponseEntity<Pago> getPagoConReserva(@PathVariable Long id) {
        Pago pago = pagoService.getPagoConReserva(id);
        return ResponseEntity.ok(pago);
    }

    // Crear Pago
    @PostMapping("/agregar")
    public ResponseEntity<Pago> createPago(@RequestBody Pago pago) {
        Pago newPago = pagoService.createPago(pago);
        return new ResponseEntity<>(newPago, HttpStatus.CREATED);
    }

    // Obtener Pago por ID
    @GetMapping("/{id}")
    public ResponseEntity<Pago> getPagoById(@PathVariable Long id) {
        Optional<Pago> pago = pagoService.getPagoById(id);
        return pago.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Obtener todos los Pagos
    @GetMapping
    public ResponseEntity<List<Pago>> getAllPagos() {
        List<Pago> pagos = pagoService.getAllPagos();
        return ResponseEntity.ok(pagos);
    }

    // Actualizar Pago
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Pago> updatePago(@PathVariable Long id, @RequestBody Pago pagoDetails) {
        Pago updatedPago = pagoService.updatePago(id, pagoDetails);
        return ResponseEntity.ok(updatedPago);
    }

    // Eliminar Pago
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deletePago(@PathVariable Long id) {
        pagoService.deletePago(id);
        return ResponseEntity.noContent().build();
    }
}
