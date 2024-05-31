package org.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

public class Ejercicio3 {
    public static void main(String[] args) throws Exception {
        // Crear 4 CompletableFuture
        CompletableFuture<Integer> future1 = createRandomDelayFuture();
        CompletableFuture<Integer> future2 = createRandomDelayFuture();
        CompletableFuture<Integer> future3 = createRandomDelayFuture();
        CompletableFuture<Integer> future4 = createRandomDelayFuture();

        // Esperar a que todas las tareas se completen
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2, future3, future4);

        // Cuando todas las tareas se completen, sumar los resultados e imprimir
        allFutures.thenAccept(v -> {
            try {
                int sum = future1.get() + future2.get() + future3.get() + future4.get();
                System.out.println("La suma de los valores es: " + sum);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Esperar a que se complete la tarea final
        allFutures.join();
    }


    //supplyAsync() es un método que ejecuta una tarea de manera asíncrona y devuelve un resultado
    //runAsync() es un método que ejecuta una tarea de manera asíncrona y no devuelve un resultado
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