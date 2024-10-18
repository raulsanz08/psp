package ejer6_hilos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuRestaurante {
    public static void main(String[] args) {

        List<String> primeros = new ArrayList<>();
        List<String> segundos = new ArrayList<>();
        List<String> postres = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("/home/rausanjim/IdeaProjects/java/src/ejer6_hilos/menu.txt"))) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                if (linea.startsWith("1-")) {
                    primeros.add(linea.substring(2));
                } else if (linea.startsWith("2-")) {
                    segundos.add(linea.substring(2));
                } else if (linea.startsWith("3-")) {
                    postres.add(linea.substring(2));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo menu.txt no encontrado.");
            return;
        }

        Thread hilo1 = new Thread(new EscribirMenu("/home/rausanjim/IdeaProjects/java/src/ejer6_hilos/primeros.txt", primeros, "Hilo 1"));
        Thread hilo2 = new Thread(new EscribirMenu("/home/rausanjim/IdeaProjects/java/src/ejer6_hilos/segundos.txt", segundos, "Hilo 2"));
        Thread hilo3 = new Thread(new EscribirMenu("/home/rausanjim/IdeaProjects/java/src/ejer6_hilos/postres.txt", postres, "Hilo 3"));

        hilo1.start();
        hilo2.start();
        hilo3.start();

        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Todos los hilos han terminado.");
    }
}

class EscribirMenu implements Runnable {
    private String archivoSalida;
    private List<String> platos;
    private String nombreHilo;

    public EscribirMenu(String archivoSalida, List<String> platos, String nombreHilo) {
        this.archivoSalida = archivoSalida;
        this.platos = platos;
        this.nombreHilo = nombreHilo;
    }

    @Override
    public void run() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(archivoSalida))) {
            for (String plato : platos) {
                writer.println(plato);
                System.out.println(nombreHilo + " escribe..." + plato);
                Thread.sleep(500);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

