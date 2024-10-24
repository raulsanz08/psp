package ejer7_hilos;

import java.util.Random;

class ReservaEntradas {
    private static int entradasDisponibles = 100;
    private static int entradasVendidas = 0;

    public synchronized static void reservarEntradas(String cliente, int cantidadEntradas) {
        if (entradasDisponibles >= cantidadEntradas) {
            entradasDisponibles -= cantidadEntradas;
            entradasVendidas += cantidadEntradas;
            System.out.println(cantidadEntradas + " reservadas para " + cliente);
        } else {
            System.out.println("No hay suficientes entradas para " + cliente + ". Entradas disponibles: " + entradasDisponibles);
        }
    }

    public static int obtenerEntradasVendidas() {
        return entradasVendidas;
    }
}

class Cliente extends Thread {
    private String nombreCliente;

    public Cliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    @Override
    public void run() {
        Random random = new Random();
        int cantidadEntradas = random.nextInt(10) + 1;
        ReservaEntradas.reservarEntradas(nombreCliente, cantidadEntradas);
    }
}

public class ReservaEntradasMain {
    public static void main(String[] args) {
        Thread[] clientes = new Thread[10];

        for (int i = 0; i < 10; i++) {
            clientes[i] = new Cliente("Cliente " + (i + 1));
            clientes[i].start();
        }

        for (int i = 0; i < 10; i++) {
            try {
                clientes[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Total entradas vendidas: " + ReservaEntradas.obtenerEntradasVendidas());
    }
}

