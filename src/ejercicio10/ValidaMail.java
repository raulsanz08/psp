package ejercicio10;

public class ValidaMail {
    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("ERROR: No se ha proporcionado ningún email.");
            return;
        }

        String email = args[0];


        if (!email.contains("@")) {
            System.out.println("ERROR: El email no contiene una @!");
            return;
        }


        String[] partes = email.split("@", 2);


        if (partes[0].length() < 3) {
            System.out.println("ERROR: El primer identificador ha de tener una longitud mínima de 3 caracteres!");
            return;
        }


        if (partes.length < 2 || partes[1].isEmpty()) {
            System.out.println("ERROR: No existe segundo identificador!");
            return;
        }


        if (!(partes[1].endsWith(".com") || partes[1].endsWith(".es") || partes[1].endsWith(".org"))) {
            System.out.println("ERROR: El dominio no es ni com/es/org!");
            return;
        }


        System.out.println("El email es válido.");
    }
}

