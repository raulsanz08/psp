package ejer4_hilos;

public class CarreraAtletismo {

    public static void main(String[] args) {
        String[] corredores = {
                "Hicham El Guerrouj", "Noah Ngeny", "Mohamed Farah",
                "Bernard Lagat", "Rashid Ramzi", "Ryan Gregson",
                "Fermín Cacho", "Teddy Flack"
        };

        for (String nombre : corredores) {
            Thread hilo = new Thread(new Corredor(nombre));
            hilo.start();
            System.out.println("El corredor " + nombre + " ha terminado la prueba.");
        }
    }
}

class Corredor implements Runnable {
    private String nombre;

    public Corredor(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 1500; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

