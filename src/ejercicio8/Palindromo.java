package ejercicio8;

public class Palindromo {

    public static boolean esPalindromo(String cadena){
            String limpia= cadena.replaceAll("\\s+", "").toLowerCase();
            String inversa= new StringBuilder(limpia).reverse().toString();
            return limpia.equals(inversa);


    }

    public static void main(String[] args) {
        if (args.length < 1){
            System.out.println("Debe proporcionar una cadena como argumento");
            return;
        }

        String cadena= args[0];

        if(esPalindromo(cadena)){
            System.out.println(cadena + " es un palindromo");
        }
        else{
            System.out.println(cadena + " no es un palindromo");
        }
    }
}
