package ejer5_hilos;

import java.util.Scanner;
import java.util.Random;

public class CarreraCoches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca número de coches a competir: ");
        int numCoches = scanner.nextInt();
        scanner.nextLine();

        Coche[] coches = new Coche[numCoches];

        for (int i = 0; i < numCoches; i++) {
            System.out.print("Introduzca marca del coche " + (i + 1) + ": ");
            String marca = scanner.nextLine();
            coches[i] = new Coche(marca, i + 1);
            System.out.println("Coche creado: " + coches[i].getMarca() + "(" + coches[i].getNumero() + ")");
        }

        System.out.println("¡Que empiece la carrera!");

        for (Coche coche : coches) {
            Thread hilo = new Thread(coche);
            hilo.start();
        }

        scanner.close();
    }
}

class Coche implements Runnable {
    private String marca;
    private int numero;
    private int distanciaTotal;
    private static final int META = 500;
    private Random random = new Random();

    public Coche(String marca, int numero) {
        this.marca = marca;
        this.numero = numero;
        this.distanciaTotal = 0;
    }

    public String getMarca() {
        return marca;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public void run() {
        while (distanciaTotal < META) {
            try {
                int distanciaRecorrida = random.nextInt(101);
                distanciaTotal += distanciaRecorrida;

                System.out.println(marca + "(" + numero + ") lleva recorrido " + distanciaTotal + "km!");

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("-----------------------------------------------------------------------");
        System.out.println("El " + marca + "(" + numero + ") ha finalizado al recorrer " + distanciaTotal + "km.");
        System.out.println("-----------------------------------------------------------------------");
    }
}
