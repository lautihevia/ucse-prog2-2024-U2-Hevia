package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StreamBenchmarkTest {
    private StreamBenchmark benchmark;

    @BeforeEach
    void setUp() {
        benchmark = new StreamBenchmark();
        benchmark.setup();
    }

    @Test
    void benchmarkStream() {
        List<Integer> result = benchmark.benchmarkStream();

        assertNotNull(result, "La lista no debería ser nula");
        assertFalse(result.isEmpty(), "La lista no debería estar vacía");

        for (Integer num : result) {
            assertTrue(num % 2 == 0, "Todos los números deben ser pares");
        }
    }

    @Test
    void benchmarkParallelStream() {
        List<Integer> result = benchmark.benchmarkParallelStream();

        assertNotNull(result, "La lista no debería ser nula");
        assertFalse(result.isEmpty(), "La lista no debería estar vacía");

        for (Integer num : result) {
            assertTrue(num % 2 == 0, "Todos los números deben ser pares");
        }
    }
}