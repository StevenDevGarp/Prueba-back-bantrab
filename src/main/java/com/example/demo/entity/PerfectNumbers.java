package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "Numeros_Perfectos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PerfectNumbers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_numero_perfecto;

    @Column(name = "numero_perfecto", nullable = false)
    private Integer numero_perfecto;

    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private Person persona;

    @ManyToOne
    @JoinColumn(name = "id_factura", nullable = false)
    private Bill factura;
}
