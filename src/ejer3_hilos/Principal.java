package ejer3_hilos;

class Cuenta {
    private int saldo;


    public Cuenta(int saldoInicial) {
        this.saldo = saldoInicial;
    }


    public int getSaldo() {
        return saldo;
    }


    public synchronized void restar(int cantidad) {
        saldo -= cantidad;
    }


    public synchronized void RetirarDinero(int cant, String nom) {
        if (saldo >= cant) {
            System.out.println(nom + ": SE VA A RETIRAR SALDO (ACTUAL ES: " + saldo + ")");
            restar(cant);
            System.out.println(nom + " retira =>" + cant + " ACTUAL(" + saldo + ")");
        } else {
            System.out.println(nom + ": No puede retirar dinero, NO HAY SALDO (saldo actual: " + saldo + ")");
        }
    }
}

class SacarDinero implements Runnable {
    private Cuenta cuenta;
    private String nombre;
    private int cantidad;


    public SacarDinero(Cuenta cuenta, String nombre, int cantidad) {
        this.cuenta = cuenta;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }


    @Override
    public void run() {
        cuenta.RetirarDinero(cantidad, nombre);
    }
}


public class Principal {
    public static void main(String[] args) throws InterruptedException {

        Cuenta cuenta = new Cuenta(40);


        Thread hiloAna = new Thread(new SacarDinero(cuenta, "Ana", 10));
        Thread hiloJuan = new Thread(new SacarDinero(cuenta, "Juan", 10));

        hiloAna.start();
        hiloJuan.start();

        hiloAna.join();
        hiloJuan.join();
    }
}


