package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "Impuestos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Taxes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_impuesto;

    @Column(name = "tasa_impuesto", nullable = false, precision = 5, scale = 2)
    private BigDecimal tasa_impuesto;

    @ManyToOne
    @JoinColumn(name = "id_caja_chica", nullable = false)
    private PettyCash cajaChica;

}
