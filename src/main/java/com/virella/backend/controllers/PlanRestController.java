package com.virella.backend.controllers;

import com.virella.backend.entities.Plan;
import com.virella.backend.services.PlanService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/planes")
@RequiredArgsConstructor
public class PlanRestController {

    private final PlanService planService;

    // Crear Plan
    @PostMapping("/agregar")
    public ResponseEntity<Plan> createPlan(@RequestBody Plan plan) {
        Plan newPlan = planService.createPlan(plan);
        return new ResponseEntity<>(newPlan, HttpStatus.CREATED);
    }

    // Obtener Plan por ID
    @GetMapping("/{id}")
    public ResponseEntity<Plan> getPlanById(@PathVariable Long id) {
        Optional<Plan> plan = planService.getPlanById(id);
        return plan.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Obtener todos los Planes
    @GetMapping
    public ResponseEntity<List<Plan>> getAllPlanes() {
        List<Plan> planes = planService.getAllPlanes();
        return ResponseEntity.ok(planes);
    }

    // Actualizar Plan
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Plan> updatePlan(@PathVariable Long id, @RequestBody Plan planDetails) {
        Plan updatedPlan = planService.updatePlan(id, planDetails);
        return ResponseEntity.ok(updatedPlan);
    }

    // Eliminar Plan
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deletePlan(@PathVariable Long id) {
        planService.deletePlan(id);
        return ResponseEntity.noContent().build();
    }
}
