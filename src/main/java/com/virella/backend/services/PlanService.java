package com.virella.backend.services;

import com.virella.backend.entities.Plan;
import com.virella.backend.repositories.PlanRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlanService {

    private final PlanRepository planRepository;

    // Crear Plan
    public Plan createPlan(Plan plan) {
        return planRepository.save(plan);
    }

    // Buscar Plan por ID
    public Optional<Plan> getPlanById(Long id) {
        return planRepository.findById(id);
    }

    // Obtener todos los Planes
    public List<Plan> getAllPlanes() {
        return planRepository.findAll();
    }

    // Actualizar Plan
    public Plan updatePlan(Long id, Plan planDetails) {
        Plan plan = planRepository.findById(id).orElseThrow(() -> new RuntimeException("Plan no encontrado"));
        plan.setNombre(planDetails.getNombre());
        plan.setDescripcion(planDetails.getDescripcion());
        return planRepository.save(plan);
    }

    // Eliminar Plan
    public void deletePlan(Long id) {
        Plan plan = planRepository.findById(id).orElseThrow(() -> new RuntimeException("Plan no encontrado"));
        planRepository.delete(plan);
    }
}
