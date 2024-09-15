package com.example.demo.service;

import com.example.demo.entity.Bill;
import com.example.demo.entity.PerfectNumbers;
import com.example.demo.entity.PettyCash;
import com.example.demo.entity.Taxes;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class PettyCashService {
    @Autowired
    PettyCashRepository cajaChicaRepository;
    @Autowired
    TaxesRepository impuestosRepository;
    @Autowired
    PerfectNumberRepository numerosPerfectosRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    BillRepository facturaRepository;

    public List<PettyCash> getAllCajaChica() {
        return cajaChicaRepository.findAll();
    }

    public List<Taxes> getAllTaxes() {
        return impuestosRepository.findAll();
    }

    public List<PerfectNumbers> getAllPerfectNumbers() {
        return numerosPerfectosRepository.findAll();
    }

    public List<Bill> getAllBills() {
        return facturaRepository.findAll();
    }
    @Transactional
    public PettyCash savePettyCahs(PettyCash PettyCash) {
        PettyCash savedPettyCash = cajaChicaRepository.save(PettyCash);

        // Calcular impuestos y guardarlos
        BigDecimal tasaImpuesto = calcularImpuesto(savedPettyCash);
        Taxes impuestos = new Taxes(null, tasaImpuesto, savedPettyCash);
        impuestosRepository.save(impuestos);

        // Calcular números perfectos y guardarlos
        calcularYGuardarNumerosPerfectos(savedPettyCash);

        return savedPettyCash;
    }

    private BigDecimal calcularImpuesto(PettyCash pettyCash) {
        // Supongamos que el impuesto es el 16% del monto.
        BigDecimal impuestoPorcentaje = new BigDecimal("0.16"); // Usamos BigDecimal para el 16%
        BigDecimal monto = pettyCash.getMonto(); // Obtenemos el monto como BigDecimal
        return monto.multiply(impuestoPorcentaje).setScale(2, RoundingMode.HALF_UP);
    }

    private void calcularYGuardarNumerosPerfectos(PettyCash pettyCash) {
        Integer numero = pettyCash.getMonto().intValue(); // Supongamos que el número a calcular proviene del monto (puedes cambiar esto).

        if (isPerfectNumber(numero)) {
            // Si el número es perfecto, lo guardamos
            PerfectNumbers numerosPerfectos = new PerfectNumbers(null, numero, pettyCash.getPersona(), pettyCash.getFactura());
            numerosPerfectosRepository.save(numerosPerfectos);
        }
    }

    private boolean isPerfectNumber(Integer numero) {
        int sumaDivisores = 0;

        // Calculamos la suma de los divisores propios (excluyendo el número en sí mismo)
        for (int i = 1; i <= numero / 2; i++) {
            if (numero % i == 0) {
                sumaDivisores += i;
            }
        }

        // Un número es perfecto si la suma de sus divisores propios es igual al número
        return sumaDivisores == numero;
    }

}
