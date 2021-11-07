package com.alcancia.alcancia.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.alcancia.alcancia.models.MonedaModel;
import com.alcancia.alcancia.repositories.MonedaRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MonedaServiceTest {

    @Mock
    private MonedaRepository monedaRepository;

    @InjectMocks
    private MonedaService monedaService;

    private MonedaModel monedaModel = new MonedaModel();
    private MonedaModel monedaModel1 = new MonedaModel();
    private MonedaModel monedaModel2 = new MonedaModel();
    private MonedaModel monedaModel3 = new MonedaModel();
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
    void testObtenerMonedas() {
        when(monedaRepository.findAll()).thenReturn(lista);
        assertNotNull(monedaService.obtenerMonedas());
    }

    @Test
    void testCantidadMonedas() {

        long cantidad = lista.size();
        when(monedaRepository.count()).thenReturn(cantidad);
        assertEquals(monedaService.CantidadMonedas(), cantidad);
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
        when(monedaRepository.findByTipo(tipo)).thenReturn(listaNueva);
        assertEquals(monedaService.CantidadMonedasByTipo(tipo), listaNueva.size());
    }

    @Test
    void testDineroMonedas() {
        long dinero = 0;
        ArrayList<MonedaModel> listaNueva = new ArrayList<MonedaModel>();
        for (MonedaModel m : lista) {
            dinero = dinero + m.getValor();
            listaNueva.add(m);
        }
        when(monedaRepository.findAll()).thenReturn(listaNueva);
        assertEquals(monedaService.DineroMonedas(), dinero);
    }

    @Test
    void testDineroMonedasByTipo() {
        long dinero = 0;
        String tipo = "50";
        ArrayList<MonedaModel> listaNueva = new ArrayList<MonedaModel>();
        for (MonedaModel m : lista) {
            String tipoMock = m.getTipo();
            Integer id = m.getId();
            if (tipoMock == tipo) {
                dinero = dinero + m.getValor();
                listaNueva.add(m);
            }
        }
        when(monedaRepository.findByTipo(tipo)).thenReturn(listaNueva);
        assertEquals(monedaService.DineroMonedasByTipo(tipo), dinero);
    }

    @Test
    void testIngresarMoneda() {
        MonedaModel monedaModelMock = new MonedaModel();
        monedaModelMock.setId(10);
        monedaModelMock.setValor(200);
        monedaModelMock.setTipo("200");
        monedaRepository.save(monedaModelMock);
        lista = Arrays.asList(monedaModel, monedaModel1, monedaModel2, monedaModelMock);
        when(monedaRepository.findAll()).thenReturn(lista);
        assertEquals(4, lista.size());
        if (lista.size() == 4) {
            assertEquals(monedaService.ingresarMoneda(monedaModelMock), true);
        }
        // Iterable<MonedaModel> listaMoneda =(Iterable) lista.iterator();
        // Assertions.assertThat(lista).extracting(MonedaModel::getTipo).contains("200");
    }

    /*@Test
    void testIngresarMonedaException() {
        MonedaModel monedaModelMock = new MonedaModel();
        monedaModelMock.setId(10);
        monedaModelMock.setValor(200);
        monedaModelMock.setTipo("200");
        when(monedaRepository.save(monedaModelMock))
        .thenThrow(new Exception());
        //monedaRepository.save(monedaModelMock);
        when(monedaRepository.findAll()).thenReturn(lista);
        assertEquals(4, lista.size());
        if (lista.size() != 4) {
            assertEquals(monedaService.ingresarMoneda(monedaModelMock), false);
        }
        // Iterable<MonedaModel> listaMoneda =(Iterable) lista.iterator();
        // Assertions.assertThat(lista).extracting(MonedaModel::getTipo).contains("200");
    }*/

}
