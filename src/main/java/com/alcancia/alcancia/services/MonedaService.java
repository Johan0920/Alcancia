package com.alcancia.alcancia.services;

import java.util.ArrayList;

import com.alcancia.alcancia.models.MonedaModel;
import com.alcancia.alcancia.repositories.MonedaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonedaService {
    @Autowired
    MonedaRepository monedaRepository;

    public ArrayList<MonedaModel> obtenerMonedas() {
        return (ArrayList<MonedaModel>) monedaRepository.findAll();
    }

    public boolean ingresarMoneda(MonedaModel moneda) {
        try {
            monedaRepository.save(moneda);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public long CantidadMonedas() {
        return monedaRepository.count();
    }

    public long CantidadMonedasByTipo(String tipo) {
        ArrayList<MonedaModel> monedasTipo;
        long cantidad = 0;
        monedasTipo = monedaRepository.findByTipo(tipo);
        for (MonedaModel p : monedasTipo) {
            p.getTipo();
            cantidad++;
        }
        return cantidad;
    }

    public long DineroMonedas() {
        ArrayList<MonedaModel> monedasTipo;
        long dinero = 0;
        monedasTipo = (ArrayList<MonedaModel>) monedaRepository.findAll();
        for (MonedaModel p : monedasTipo) {
            dinero = dinero + p.getValor();
        }
        return dinero;
    }

    public long DineroMonedasByTipo(String tipo) {
        ArrayList<MonedaModel> monedasTipo;
        long dinero = 0;
        monedasTipo = monedaRepository.findByTipo(tipo);
        for (MonedaModel p : monedasTipo) {
            dinero = dinero + p.getValor();
        }
        return dinero;
    }
}
