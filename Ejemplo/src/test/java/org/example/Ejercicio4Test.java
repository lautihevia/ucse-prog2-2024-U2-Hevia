package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class Ejercicio4Test {

    @Test
    void runFinalizarPrimeraTarea() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        try {
            new Ejercicio4().runFinalizarPrimeraTarea();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String output = outContent.toString();
        assertTrue(output.contains("El valor del primer futuro completado es: "));
    }
}