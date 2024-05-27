package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AvionComercialTest {

    @Test
    void VolarConDistancia50YConsumo2CalculaCombustible() {
        AvionComercial avionComercial = new AvionComercial(100, 2);
        int distancia = 50;
        assertEquals(100, avionComercial.volar(distancia));
    }
}