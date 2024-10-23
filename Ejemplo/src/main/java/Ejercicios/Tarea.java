package Ejercicios;

public class Tarea {
    public int tarea () {
        int random = (int) (Math.random() * 800) + 80;
        try {
            Thread.sleep(random);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return random;
    }
}