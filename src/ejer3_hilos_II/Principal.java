package ejer3_hilos_II;

public class Principal {
    public static void main(String[] args) {
        Saludo saludo = new Saludo();

        Empleado empleado1 = new Empleado("Empleado 1", saludo, false);
        Empleado empleado2 = new Empleado("Empleado 2", saludo, false);
        Empleado empleado3 = new Empleado("Empleado 3", saludo, false);
        Empleado jefe = new Empleado("Jefe", saludo, true);

        Thread hiloEmpleado1 = new Thread(() -> empleado1.saludar());
        Thread hiloEmpleado2 = new Thread(() -> empleado2.saludar());
        Thread hiloEmpleado3 = new Thread(() -> empleado3.saludar());
        Thread hiloJefe = new Thread(() -> jefe.saludar());

        hiloEmpleado1.start();
        hiloEmpleado2.start();
        hiloEmpleado3.start();
        hiloJefe.start();

        try {
            hiloEmpleado1.join();
            hiloEmpleado2.join();
            hiloEmpleado3.join();
            hiloJefe.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
