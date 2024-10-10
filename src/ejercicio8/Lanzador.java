package ejercicio8;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lanzador {

    public static void lanzarProceso(String clase, String... argumentos){
        try{
            List<String> comando = new ArrayList<>();
            comando.add("java");
            comando.add(clase);

            comando.addAll(Arrays.asList(argumentos));

            ProcessBuilder builder = new ProcessBuilder(comando);


            Process proceso= builder.start();

            BufferedReader reader= new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String linea;
            while((linea = reader.readLine()) != null){
                System.out.println(linea);
            }

            proceso.waitFor();
        }catch(IOException | InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        lanzarProceso("Mayusculas", "Anita lava la tina");

        lanzarProceso("Palindromo", "Anita lava la tina");

        lanzarProceso("GestorPalindromos", "ala", "somos", "polop", "casa", "palabra", "radar");
    }
}
