package com.alcancia.alcancia.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.alcancia.alcancia.models.MonedaModel;
import com.alcancia.alcancia.repositories.MonedaRepository;
import com.alcancia.alcancia.services.MonedaService;

//import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;

public class MonedaControllerTest {

    @Mock
    private MonedaService monedaService;

    @InjectMocks
    private MonedaController monedaController;

    private MonedaModel monedaModel = new MonedaModel();
    private MonedaModel monedaModel1 = new MonedaModel();
    private MonedaModel monedaModel2 = new MonedaModel();
    private List<MonedaModel> lista;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        monedaModel.setId(1);
        monedaModel.setValor(50);
        monedaModel.setTipo("50");

        monedaModel1.setId(2);
        monedaModel1.setValor(50);
        monedaModel1.setTipo("50");

        monedaModel2.setId(3);
        monedaModel2.setValor(100);
        monedaModel2.setTipo("100");

        lista = Arrays.asList(monedaModel, monedaModel1, monedaModel2);
    }

    @Test
    public void testObtenerMonedas() {
        when(monedaService.obtenerMonedas()).thenReturn(lista);
        assertNotNull(monedaController.obtenerMonedas());
    }

    @Test
    void testCantidadMonedas() {

        long cantidad = lista.size();
        when(monedaService.CantidadMonedas()).thenReturn(cantidad);
        assertEquals(monedaController.CantidadMonedas(), cantidad);
    }

    @Test
    void testCantidadMonedasByTipo() {
        String tipo = "50";
        ArrayList<MonedaModel> listaNueva = new ArrayList<MonedaModel>();
        for (MonedaModel m : lista) {
            String tipoMock = m.getTipo();
            if (tipoMock == tipo) {
                listaNueva.add(m);
            }
        }
        when(monedaService.CantidadMonedasByTipo(tipo)).thenReturn((long) listaNueva.size());
        assertEquals(monedaController.CantidadMonedasByTipo(tipo), listaNueva.size());
    }

    @Test
    void testDineroMonedas() {
        long dinero = 0;
        ArrayList<MonedaModel> listaNueva = new ArrayList<MonedaModel>();
        for (MonedaModel m : lista) {
            dinero = dinero + m.getValor();
            listaNueva.add(m);
        }
        when(monedaService.DineroMonedas()).thenReturn(dinero);
        assertEquals(monedaController.DineroMonedas(), dinero);
    }

    @Test
    void testDineroMonedasByTipo() {
        long dinero = 0;
        String tipo = "50";
        ArrayList<MonedaModel> listaNueva = new ArrayList<MonedaModel>();
        for (MonedaModel m : lista) {
            String tipoMock = m.getTipo();
            if (tipoMock == tipo) {
                dinero = dinero + m.getValor();
                listaNueva.add(m);
            }
        }
        when(monedaService.DineroMonedasByTipo(tipo)).thenReturn(dinero);
        assertEquals(monedaController.DineroMonedasByTipo(tipo), dinero);
    }

    @Test
    void testIngresarMoneda50() {
        String mensajeOk = "Moneda ingresada a la alcancía de forma correcta";
        MonedaModel monedaModelMock = new MonedaModel();
        monedaModelMock.setId(10);
        monedaModelMock.setValor(50);
        monedaModelMock.setTipo("50");
        if (monedaModelMock.getTipo() == "50") {
            when(monedaService.ingresarMoneda(monedaModelMock)).thenReturn(true);
            assertEquals(monedaController.ingresarMoneda(monedaModelMock), mensajeOk);
        }
    }

    @Test
    void testIngresarMoneda100() {
        String mensajeOk = "Moneda ingresada a la alcancía de forma correcta";
        MonedaModel monedaModelMock = new MonedaModel();
        monedaModelMock.setId(10);
        monedaModelMock.setValor(100);
        monedaModelMock.setTipo("100");
        if (monedaModelMock.getTipo() == "100") {
            when(monedaService.ingresarMoneda(monedaModelMock)).thenReturn(true);
            assertEquals(monedaController.ingresarMoneda(monedaModelMock), mensajeOk);
        }
    }

    @Test
    void testIngresarMoneda200() {
        String mensajeOk = "Moneda ingresada a la alcancía de forma correcta";
        MonedaModel monedaModelMock = new MonedaModel();
        monedaModelMock.setId(10);
        monedaModelMock.setValor(200);
        monedaModelMock.setTipo("200");
        if (monedaModelMock.getTipo() == "200") {
            when(monedaService.ingresarMoneda(monedaModelMock)).thenReturn(true);
            assertEquals(monedaController.ingresarMoneda(monedaModelMock), mensajeOk);
        }
    }

    @Test
    void testIngresarMoneda500() {
        String mensajeOk = "Moneda ingresada a la alcancía de forma correcta";
        MonedaModel monedaModelMock = new MonedaModel();
        monedaModelMock.setId(10);
        monedaModelMock.setValor(500);
        monedaModelMock.setTipo("500");
        if (monedaModelMock.getTipo() == "500") {
            when(monedaService.ingresarMoneda(monedaModelMock)).thenReturn(true);
            assertEquals(monedaController.ingresarMoneda(monedaModelMock), mensajeOk);
        }
    }

    @Test
    void testIngresarMoneda1000() {
        String mensajeOk = "Moneda ingresada a la alcancía de forma correcta";
        MonedaModel monedaModelMock = new MonedaModel();
        monedaModelMock.setId(10);
        monedaModelMock.setValor(1000);
        monedaModelMock.setTipo("1000");
        if (monedaModelMock.getTipo() == "1000") {
            when(monedaService.ingresarMoneda(monedaModelMock)).thenReturn(true);
            assertEquals(monedaController.ingresarMoneda(monedaModelMock), mensajeOk);
        }
    }

    @Test
    void testIngresarMonedaNotEqual() {
        MonedaModel monedaModelMock = new MonedaModel();
        monedaModelMock.setId(10);
        monedaModelMock.setValor(1000);
        monedaModelMock.setTipo("200");
        if (monedaModelMock.getValor() != Integer.parseInt(monedaModelMock.getTipo())) {
            assertEquals(monedaController.ingresarMoneda(monedaModelMock),
                    "el valor de la moneda no corresponde al tipo");
        }
    }

    @Test
    void testIngresarMonedaDiferentes() {
        String mensajeErr = "Las monedas deben ser de 50, 100, 200, 500 o 1.000";
        MonedaModel monedaModelMock = new MonedaModel();
        monedaModelMock.setId(10);
        monedaModelMock.setValor(300);
        monedaModelMock.setTipo("300");
        if ((monedaModelMock.getTipo() != "50") || 
            (monedaModelMock.getTipo() != "100") || 
            (monedaModelMock.getTipo() != "200") ||
            (monedaModelMock.getTipo() != "500") ||
            (monedaModelMock.getTipo() != "1000")) {
            when(monedaService.ingresarMoneda(monedaModelMock)).thenReturn(true);
            assertEquals(monedaController.ingresarMoneda(monedaModelMock), mensajeErr);
        }
    }

    /*
     * @Test void testIngresarMoneda() { String mensajeOk =
     * "Moneda ingresada a la alcancía de forma correcta"; //String mensajeErr =
     * "Las monedas deben ser de 50, 100, 200, 500 o 1.000"; MonedaModel
     * monedaModelMock = new MonedaModel(); monedaModelMock.setId(10);
     * monedaModelMock.setValor(200); monedaModelMock.setTipo("200"); if
     * (monedaModelMock.getValor() != Integer.parseInt(monedaModelMock.getTipo())) {
     * assertEquals(monedaController.ingresarMoneda(monedaModelMock),
     * "el valor de la moneda no corresponde al tipo"); } switch
     * (monedaModelMock.getTipo()) { case "50":
     * when(monedaService.ingresarMoneda(monedaModelMock)).thenReturn(true);
     * assertEquals(monedaController.ingresarMoneda(monedaModelMock), mensajeOk);
     * case "100":
     * when(monedaService.ingresarMoneda(monedaModelMock)).thenReturn(true);
     * assertEquals(monedaController.ingresarMoneda(monedaModelMock), mensajeOk);
     * case "200":
     * when(monedaService.ingresarMoneda(monedaModelMock)).thenReturn(true);
     * assertEquals(monedaController.ingresarMoneda(monedaModelMock), mensajeOk);
     * case "500":
     * when(monedaService.ingresarMoneda(monedaModelMock)).thenReturn(true);
     * assertEquals(monedaController.ingresarMoneda(monedaModelMock), mensajeOk);
     * case "1000":
     * when(monedaService.ingresarMoneda(monedaModelMock)).thenReturn(true);
     * assertEquals(monedaController.ingresarMoneda(monedaModelMock), mensajeOk); /*
     * default:
     * when(monedaService.ingresarMoneda(monedaModelMock)).thenReturn(false);
     */
    // }
    // }
}
