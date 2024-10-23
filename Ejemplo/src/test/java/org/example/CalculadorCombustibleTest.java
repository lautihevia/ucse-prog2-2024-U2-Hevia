package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

class CalculadorCombustibleTest {

    private CalculadorCombustible calculador;
    @BeforeEach
    public void setup(){
        calculador = CalculadorCombustible.getInstance();
    }

    @Test
    public void testCalcularConsumoAvionComercialRetorna5000() {
        Avion avion = new AvionComercial(100, 10);
        int consumo = calculador.calcularCombustible(avion, 500);
        assertEquals(5000, consumo);
    }

    @Test
    public void testCalcularConsumoAvionPrivadoRetorna2600() {
        Avion avion = new AvionPrivado(100, 10);
        int consumo = calculador.calcularCombustible(avion, 255);
        assertEquals(2600, consumo);
    }

    @Test
    public void testGetInstanceRetornaMismaInstancia() {
        CalculadorCombustible instance2 = CalculadorCombustible.getInstance();
        assertEquals(calculador, instance2);
    }

    @Test
    void calcularCombustible() {
        Avion avionMock = Mockito.mock(Avion.class);
        Mockito.when(avionMock.volar(Mockito.anyInt())).thenReturn(100);

        int resultado = calculador.calcularCombustible(avionMock, 50);

        assertEquals(100, resultado, "El resultado debe ser 100");
    }
}