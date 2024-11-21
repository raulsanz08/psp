package ejer3_hilos_II;

class Saludo extends Thread {
    private boolean jefeHaSaludado = false;

    public synchronized void saludoEmpleado(String nombre) {
        while (!jefeHaSaludado) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(nombre + ": ¡Buenos días, jefe!");
    }

    public synchronized void saludoJefe(String nombre) {
        System.out.println(nombre + ": ¡Buenos días, equipo!");
        jefeHaSaludado = true;
        notifyAll();
    }
}