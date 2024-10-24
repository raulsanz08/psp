package ejer8_hilos;

import java.util.ArrayList;
import java.util.List;

public class ParesImparesLambda {
    public static void main(String[] args) {

        List<Integer> pares = new ArrayList<>();
        List<Integer> impares = new ArrayList<>();

        Thread hiloPares = new Thread(() -> {
            for (int i = 0; i <= 20; i++) {
                if (i % 2 == 0) {
                    pares.add(i);
                }
            }
            System.out.println("Números pares: " + pares);
        });

        Thread hiloImpares = new Thread(() -> {
            for (int i = 0; i <= 20; i++) {
                if (i % 2 != 0) {
                    impares.add(i);
                }
            }
            System.out.println("Números impares: " + impares);
        });

        hiloPares.start();
        hiloImpares.start();

        try {
            hiloPares.join();
            hiloImpares.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Hilos de pares e impares completados.");
    }
}

