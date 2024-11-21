package ejer2_hilos_II;

public class SincronizacionContador {

    public static void main(String[] args) {
        Contador contador = new Contador(100); // Inicializamos el contador con el valor 100

        // Hilo para incrementar
        Thread incrementador = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                contador.incrementar();
            }
        });

        // Hilo para decrementar
        Thread decrementador = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                contador.decrementar();
            }
        });

        // Iniciar los hilos
        incrementador.start();
        decrementador.start();

        // Esperar a que ambos hilos terminen
        try {
            incrementador.join();
            decrementador.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Imprimir el valor final del contador
        System.out.println("Valor final del contador: " + contador.getValor());
    }
}