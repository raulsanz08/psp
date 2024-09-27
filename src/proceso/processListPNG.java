package proceso;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class processListPNG {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce la ruta del directorio: ");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.isDirectory()) {

            FilenameFilter pngFilter = new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.toLowerCase().endsWith(".png");
                }
            };

            String[] pngFiles = directory.list(pngFilter);

            if (pngFiles != null && pngFiles.length > 0) {
                System.out.println("Archivos PNG encontrados:");
                for (String fileName : pngFiles) {
                    System.out.println(fileName);
                }
            } else {
                System.out.println("No se encontraron archivos PNG en el directorio.");
            }
        } else {
            System.out.println("La ruta proporcionada no es un directorio válido.");
        }

        scanner.close();
    }
}
