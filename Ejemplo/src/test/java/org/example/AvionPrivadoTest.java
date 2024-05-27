package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AvionPrivadoTest {

    @Test
    void testVolarConDistancia50YConsumo2CalculaCombustibleNecesario125() {
        AvionPrivado avionPrivado = new AvionPrivado(100, 2);
        int distancia = 50;
        int resultadoEsperado = (distancia * 2) + (100 / 2); // El consumo de combustible es 2 y la capacidad es 100
        assertEquals(resultadoEsperado, avionPrivado.volar(distancia));
    }
}