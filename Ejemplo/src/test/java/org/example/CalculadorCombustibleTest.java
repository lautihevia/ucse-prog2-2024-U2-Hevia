package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

class CalculadorCombustibleTest {

    @Test
    void testGetInstance_notNull() {
        CalculadorCombustible instance = CalculadorCombustible.getInstance();
        assertNotNull(instance, "La instancia no debería ser nula");
    }

    @Test
    public void testGetInstance_singleton() {
        CalculadorCombustible instance1 = CalculadorCombustible.getInstance();
        CalculadorCombustible instance2 = CalculadorCombustible.getInstance();
        assertSame(instance1, instance2, "Las instancias deben ser las mismas");
    }

    @Test
    void calcularCombustible() {
        Avion avionMock = Mockito.mock(Avion.class);
        Mockito.when(avionMock.volar(Mockito.anyInt())).thenReturn(100);

        CalculadorCombustible calculador = CalculadorCombustible.getInstance();

        int resultado = calculador.calcularCombustible(avionMock, 50);

        assertEquals(100, resultado, "El resultado debe ser 100");
    }
}