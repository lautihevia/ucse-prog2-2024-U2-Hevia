package org.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

public class Ejercicio4 {
    public void runFinalizarPrimeraTarea() throws Exception {
        // Crear 4 CompletableFuture
        CompletableFuture<Integer> future1 = createRandomDelayFuture();
        CompletableFuture<Integer> future2 = createRandomDelayFuture();
        CompletableFuture<Integer> future3 = createRandomDelayFuture();
        CompletableFuture<Integer> future4 = createRandomDelayFuture();

        // Esperar a que cualquier tarea se complete
        CompletableFuture<Object> anyFuture = CompletableFuture.anyOf(future1, future2, future3, future4);

        // Cuando cualquier tarea se complete, imprimir el resultado
        anyFuture.thenAccept(v -> {
                System.out.println("El valor del primer futuro completado es: " + v);
        });

        // Esperar a que se complete la tarea final
        anyFuture.join();
    }

    private static CompletableFuture<Integer> createRandomDelayFuture() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                int delay = ThreadLocalRandom.current().nextInt(100, 501);
                String threadName = Thread.currentThread().getName();
                System.out.println("Hilo " + threadName + " iniciado con un retraso de " + delay + " milisegundos.");
                Thread.sleep(delay);
                System.out.println("Hilo " + threadName + " terminado después de " + delay + " milisegundos.");
                return delay;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}