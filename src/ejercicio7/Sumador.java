package ejercicio7;

public class Sumador {
    public static int sumar(int num1, int num2){
        int suma= 0;
        for(int i= num1; i<=num2; i++){
            suma+=i;
        }
        return suma;
    }

    public static void main(String[] args) {
       if(args.length < 2){
           System.out.println("Debe proporcionar almenos dos números como argumentos");
           return;
       }

       try{
           int num1= Integer.parseInt(args[0]);
           int num2= Integer.parseInt(args[1]);

           int resultado= sumar(num1, num2);

           System.out.println("La suma de los números " + num1 + " y " + num2 + " es: " + resultado);
       }catch(NumberFormatException e){
           System.out.println("Ingrese solo numeros enteros válidos");
       }
    }
}
