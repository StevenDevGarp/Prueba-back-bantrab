package com.example.demo.Controller;

import com.example.demo.entity.Bill;
import com.example.demo.entity.PerfectNumbers;
import com.example.demo.entity.PettyCash;
import com.example.demo.entity.Taxes;
import com.example.demo.service.PettyCashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/caja-chica")
public class CajaChicaController {

    @Autowired
    private PettyCashService cajaChicaService;

    @GetMapping
    @CrossOrigin()
    public List<PettyCash> getAllCajaChica() {
        return cajaChicaService.getAllCajaChica();
    }

    @GetMapping(path = "/taxes")
    @CrossOrigin()
    public List<Taxes> getAllTaxes() {
        return cajaChicaService.getAllTaxes();
    }

    @GetMapping(path = "/perfect-numbers")
    @CrossOrigin()
    public List<PerfectNumbers> getAllPerfectNumbers() {
        return cajaChicaService.getAllPerfectNumbers();
    }

    @GetMapping(path = "/bills")
    @CrossOrigin()
    public List<Bill> getAllBill() {
        return cajaChicaService.getAllBills();
    }

    @PostMapping
    @CrossOrigin()
    public PettyCash saveCajaChica(@RequestBody PettyCash cajaChica) {
        return cajaChicaService.savePettyCahs(cajaChica);
    }
}
