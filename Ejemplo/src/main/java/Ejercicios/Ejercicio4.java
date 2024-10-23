package Ejercicios;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;

public class Ejercicio4 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Tarea tarea = new Tarea();
        CompletableFuture<Integer> tarea1 = CompletableFuture.supplyAsync(tarea::tarea);
        CompletableFuture<Integer> tarea2 = CompletableFuture.supplyAsync(tarea::tarea);
        CompletableFuture<Integer> tarea3 = CompletableFuture.supplyAsync(tarea::tarea);
        CompletableFuture<Integer> tarea4 = CompletableFuture.supplyAsync(tarea::tarea);

        // Busca la primera tarea terminada
        CompletableFuture<Object> result = CompletableFuture.anyOf(tarea1, tarea2, tarea3, tarea4);

        System.out.println("La primer tarea en terminar fue: " + result.getClass().getName());
        System.out.println("Tarea completada: "+ result.get());
    }


}