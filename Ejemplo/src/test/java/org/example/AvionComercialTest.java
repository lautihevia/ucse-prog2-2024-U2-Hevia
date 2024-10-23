package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AvionComercialTest {

    private Avion avion;
    @BeforeEach
    public void setup(){
        avion = new AvionComercial(100, 10);
    }

    @Test
    void VolarConDistancia50YConsumo2CalculaCombustible() {
        AvionComercial avionComercial = new AvionComercial(100, 2);
        int distancia = 50;
        assertEquals(100, avionComercial.volar(distancia));
    }

    @Test
    public void testObtenerConsumoCombustibleRetorna10() {
        int consumo = avion.getConsumoCombustible();
        assertEquals(10, consumo);
    }
}