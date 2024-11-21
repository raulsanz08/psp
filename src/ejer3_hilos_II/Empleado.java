package ejer3_hilos_II;

class Empleado {
    private String nombre;
    private Saludo saludo;
    private boolean esJefe;

    public Empleado(String nombre, Saludo saludo, boolean esJefe) {
        this.nombre = nombre;
        this.saludo = saludo;
        this.esJefe = esJefe;
    }

    public void saludar() {
        if (esJefe) {
            saludo.saludoJefe(nombre);
        } else {
            saludo.saludoEmpleado(nombre);
        }
    }
}
