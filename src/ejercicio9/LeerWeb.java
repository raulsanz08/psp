package ejercicio9;

import java.io.*;
import java.util.Scanner;

public class LeerWeb {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.println("Introduce hasta 3 páginas web separadas por '@': ");
        String paginasWeb = sc.nextLine();


        String[] webs = paginasWeb.split("@");


        if (webs.length > 3) {
            System.out.println("ERROR: Demasiadas webs! Solo puedes introducir hasta 3 webs.");
            return;
        }


        try {
            ProcessBuilder pb = new ProcessBuilder("java", "Visitaweb", paginasWeb);
            pb.inheritIO(); //
            Process p = pb.start();
            p.waitFor(); //
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
