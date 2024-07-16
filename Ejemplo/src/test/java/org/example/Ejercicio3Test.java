package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;

class Ejercicio3Test {

    @Test
    void runFinalizar4Tareas() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        try {
            new Ejercicio3().runFinalizar4Tareas();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String output = outContent.toString();
        assertTrue(output.contains("La suma de los valores es: "));
    }

    @Test
    public void testCreateRandomDelayFuture() throws Exception {
        Ejercicio3 mock = Mockito.spy(Ejercicio3.class);
        Method method = Ejercicio3.class.getDeclaredMethod("createRandomDelayFuture");
        method.setAccessible(true);

        CompletableFuture<Integer> future = (CompletableFuture<Integer>) method.invoke(mock);
        assertTrue(future.get() >= 100 && future.get() <= 500);
    }
}