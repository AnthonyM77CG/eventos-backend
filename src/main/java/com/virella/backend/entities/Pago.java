package com.virella.backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.virella.backend.util.EstadoPago;
import com.virella.backend.util.MetodoPago;

@Entity
@Table(name = "pagos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal monto;

    @Enumerated(EnumType.STRING)
    @Column(name = "metodo_pago")
    private MetodoPago metodoPago;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_pago")
    private EstadoPago estadoPago;

    @Column(name = "fecha_pago")
    private LocalDateTime fechaPago;

    @OneToOne
    @JoinColumn(name = "id_reserva")
    @JsonIgnoreProperties("pago")
    private Reserva reserva;
}
