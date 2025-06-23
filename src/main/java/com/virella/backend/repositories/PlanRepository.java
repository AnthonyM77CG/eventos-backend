package com.virella.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virella.backend.entities.Plan;

public interface PlanRepository extends JpaRepository<Plan, Long> {
}
