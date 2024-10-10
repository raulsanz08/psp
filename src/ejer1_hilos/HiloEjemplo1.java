package ejer1_hilos;


class HiloEjemplo1 extends Thread {
        private String nombreHilo;


        public HiloEjemplo1(String nombre) {
            this.nombreHilo = nombre;
            System.out.println("CREANDO HILO: " + nombreHilo);
        }

        public void run() {

            for (int i = 0; i < 3; i++) {
                System.out.println("Hilo: " + nombreHilo + " = " + i);
                try {

                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("El hilo " + nombreHilo + " fue interrumpido.");
                }
            }
            System.out.println("Hilo " + nombreHilo + " finalizado.");
        }

        public static void main(String[] args) {
            int n = 3;
            Thread[] hilos = new Thread[n];


            for (int i = 0; i < n; i++) {
                hilos[i] = new HiloEjemplo1("Hilo " + (i + 1));
                hilos[i].start();
            }


            for (int i = 0; i < n; i++) {
                try {
                    hilos[i].join(); //
                } catch (InterruptedException e) {
                    System.out.println("Error esperando al hilo " + hilos[i].getName());
                }
            }

            System.out.println(n + " HILOS INICIADOS... y finalizados");
        }
    }


