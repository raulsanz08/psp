package ejercicio6;

import java.io.IOException;

public class ProcessKillNotepad {

    public static void main(String[] args) {
        try {

            ProcessBuilder processBuilder = new ProcessBuilder("nano");

            Process process = processBuilder.start();

            System.out.println("Editor de texto iniciado. Esperando 10 segundos...");

            Thread.sleep(10000);

            System.out.println("Han pasado 10 segundos, terminando editor de texto.");

            process.destroy();

            System.out.println("Proceso terminado.");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
