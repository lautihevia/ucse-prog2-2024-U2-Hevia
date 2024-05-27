package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AvionTest {

    @Test
    void testGetConsumoCombustible() {
        Avion avion = new Avion(100, 2) {
            @Override
            public int volar(int distancia) {
                return 0;
            }
        };
        assertEquals(2, avion.getConsumoCombustible());
    }
}