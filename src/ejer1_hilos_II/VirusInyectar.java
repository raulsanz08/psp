package ejer1_hilos_II;

import java.util.Random;
import java.util.Scanner;

public class VirusInyectar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca número de virus a cargar...");
        int numVirus = scanner.nextInt();
        scanner.close();

        for (int i = 1; i <= numVirus; i++) {
            int virusNumber = i;
            Thread virusThread = new Thread(() -> {
                simulateVirus(virusNumber);
            });

            virusThread.start();

            try {
                virusThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("HAS SIDO INFECTADO!");
    }

    private static void simulateVirus(int virusNumber) {
        System.out.print("Virus " + virusNumber + ":");
        int progress = 0;
        Random random = new Random();

        while (progress < 100) {
            try {
                int increment = random.nextBoolean() ? 5 : 10;
                progress += increment;

                if (progress > 100) {
                    progress = 100;
                }

                if (increment == 5) {
                    System.out.print("X");
                } else {
                    System.out.print("XX");
                }

                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(" 100%");
    }
}

