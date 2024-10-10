package ejercicio7;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Lanzador {

    public static void lanzarProceso(String n1, String n2){
        try{
            ProcessBuilder pb= new ProcessBuilder("java", "Sumador", n1, n2);

            Process p= pb.start();

            BufferedReader br= new BufferedReader(new InputStreamReader(p.getInputStream()));
            String linea;
            while((linea = br.readLine()) != null){
                System.out.println(linea);
            }

            p.waitFor();

        } catch(IOException | InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        lanzarProceso("3", "7");
        lanzarProceso("5", "10");
        lanzarProceso("0", "8");
    }

}
