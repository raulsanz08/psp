package ejercicio9;

import java.awt.Desktop;
import java.net.URI;

public class Visitaweb {
    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("ERROR: No se ha recibido ninguna página web.");
            return;
        }


        String paginasWeb = args[0];
        String[] webs = paginasWeb.split("@");


        try {
            if (webs.length == 1) {
                abrirNavegador(webs[0]);
            } else if (webs.length == 2) {
                abrirNavegador(webs[0]);
                abrirNavegador(webs[1]);
            } else if (webs.length == 3) {
                abrirNavegador(webs[0]);
                abrirNavegador(webs[1]);
                abrirNavegador(webs[2]);
            } else {
                System.out.println("ERROR: Demasiadas webs! Solo puedes abrir hasta 3.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void abrirNavegador(String url) {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();

                desktop.browse(new URI("http://" + url));
            } else {
                System.out.println("ERROR: No se puede abrir el navegador.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

