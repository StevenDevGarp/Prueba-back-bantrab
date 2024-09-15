package com.example.demo.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
@Entity
@Table(name = "caja_chica")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PettyCash {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_caja_chica;

    @Column(name = "monto")
    private BigDecimal monto;

    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private Person persona;

    @ManyToOne
    @JoinColumn(name = "id_factura", nullable = false)
    private Bill factura;

    @Column(name = "fecha", nullable = false)
    private Date fecha;
}
