package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class AvionPrivadoTest {

    private Avion avion;
    @BeforeEach
    public void setup(){
        avion = new AvionPrivado(100, 20);
    }

    @Test
    void testVolarConDistancia50YConsumo2CalculaCombustibleNecesario125() {
        AvionPrivado avionPrivado = new AvionPrivado(100, 2);
        int distancia = 50;
        int resultadoEsperado = (distancia * 2) + (100 / 2); // El consumo de combustible es 2 y la capacidad es 100
        assertEquals(resultadoEsperado, avionPrivado.volar(distancia));
    }
}