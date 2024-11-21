package ejer2_hilos_II;

class Contador {
    private int valor;

    public Contador(int valor) {
        this.valor = valor;
    }

    public synchronized void incrementar() {
        valor++;
    }

    public synchronized void decrementar() {
        valor--;
    }

    public synchronized int getValor() {
        return valor;
    }
}
