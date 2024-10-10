package ejercicio8;

public class Mayusculas {
    public static void main(String[] args){
        if(args.length < 1){
            System.out.println("Debe proporcionarme una cadena como argumento");
            return;
        }

        String cadena= args[0];

        String mayusculas= cadena.toUpperCase();

        System.out.println("La cadena en mayusculas: " + mayusculas);
    }
}
