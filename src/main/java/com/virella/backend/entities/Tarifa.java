package com.virella.backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tarifas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarifa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_espacio")
    @JsonIgnoreProperties({"reservas", "tarifas"})
    private EspacioEvento espacio;

    @ManyToOne
    @JoinColumn(name = "id_plan")
    @JsonIgnoreProperties("reservas")
    private Plan plan;

    private BigDecimal precio;
}
