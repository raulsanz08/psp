package ejercicio10;

import java.io.*;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int intentos = 0;
        boolean emailValido = false;

        while (intentos < 3 && !emailValido) {
            System.out.println("Introduce tu dirección de email: ");
            String email = sc.nextLine();


            try {
                ProcessBuilder pb = new ProcessBuilder("java", "ValidaMail", email);
                pb.redirectErrorStream(true);
                Process proceso = pb.start();


                BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
                String linea;
                while ((linea = reader.readLine()) != null) {
                    System.out.println(linea);
                    if (linea.contains("El email es válido")) {
                        emailValido = true;
                    }
                }


                proceso.waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }


            if (!emailValido) {
                intentos++;
                if (intentos == 3) {
                    System.out.println("Has excedido los 3 intentos. El programa finalizará.");
                }
            } else {
                System.out.println("Felicidades, el email es válido.");
            }
        }

        sc.close();
    }
}
