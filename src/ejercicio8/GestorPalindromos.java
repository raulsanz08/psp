package ejercicio8;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GestorPalindromos {

    public static boolean esPalindromo(String palabra){
        String limpia= palabra.replaceAll("\\s+", "").toLowerCase();
        String inversa= new StringBuilder(limpia).reverse().toString();
        return limpia.equals(inversa);
    }

    public static void guardarPalabra(String palabra){
        try{
            BufferedWriter todasWriter= new BufferedWriter(new FileWriter("todas.txt", true));
            todasWriter.write(palabra);
            todasWriter.newLine();
            todasWriter.close();

            if(esPalindromo(palabra)){
                BufferedWriter palindromoWriter= new BufferedWriter(new FileWriter("palindromo.txt", true));
                palindromoWriter.write(palabra);
                palindromoWriter.newLine();
                palindromoWriter.close();
            }else{
                BufferedWriter nopalindromoWriter= new BufferedWriter(new FileWriter("nopalindromo.txt", true));
                nopalindromoWriter.write(palabra);
                nopalindromoWriter.newLine();
                nopalindromoWriter.close();
            }
        }catch (IOException e){
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
    public static void main(String[]args){
        if (args.length<1){
            System.out.println("Debe proporcionar almenos una palabra como argumento");
            return;
        }
        for (String palabra : args){
            guardarPalabra(palabra);
        }
    }
}
