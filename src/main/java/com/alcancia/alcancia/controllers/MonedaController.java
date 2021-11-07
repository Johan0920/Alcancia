package com.alcancia.alcancia.controllers;

import com.alcancia.alcancia.models.MonedaModel;
import com.alcancia.alcancia.services.MonedaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping("/cantidad")
public class MonedaController {
    @Autowired
    MonedaService monedaService=new MonedaService();


    @GetMapping("/listarmonedas")
    public Iterable<MonedaModel> obtenerMonedas() {
        return monedaService.obtenerMonedas();
    }

    @PostMapping("/ingresarmoneda")
    public String ingresarMoneda(@RequestBody MonedaModel moneda) {
        String mensajeOk = "Moneda ingresada a la alcancía de forma correcta";
        String mensajeErr = "Las monedas deben ser de 50, 100, 200, 500 o 1.000";
        if (moneda.getValor() != Integer.parseInt(moneda.getTipo())) {
            return "el valor de la moneda no corresponde al tipo";
        }
        switch (moneda.getTipo()) {
        case "50":
            monedaService.ingresarMoneda(moneda);
            return mensajeOk;
        case "100":
            monedaService.ingresarMoneda(moneda);
            return mensajeOk;
        case "200":
            monedaService.ingresarMoneda(moneda);
            return mensajeOk;
        case "500":
            monedaService.ingresarMoneda(moneda);
            return mensajeOk;
        case "1000":
            monedaService.ingresarMoneda(moneda);
            return mensajeOk;
        default:
            return mensajeErr;
        }

    }

    @GetMapping("/cantidad")
    public long CantidadMonedas() {
        return monedaService.CantidadMonedas();
    }

    @GetMapping(path = "/cantidad/{tipo}")
    public long CantidadMonedasByTipo(@PathVariable("tipo") String tipo) {
        return monedaService.CantidadMonedasByTipo(tipo);
    }

    @GetMapping("/dinero")
    public long DineroMonedas() {
        return monedaService.DineroMonedas();
    }

    @GetMapping(path = "/dinero/{tipo}")
    public long DineroMonedasByTipo(@PathVariable("tipo") String tipo) {
        return monedaService.DineroMonedasByTipo(tipo);
    }
}
