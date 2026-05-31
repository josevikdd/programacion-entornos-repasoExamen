package org.example.model;

public class Bibliotecario extends Persona implements Mostrable {

    private String puesto;

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Bibliotecario(String dni, String nombre, String puesto) {
        super(dni, nombre);
        this.puesto = puesto;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("DNI: " + getDni() +  " Nombre: " + getNombre() +  " Puesto: " + getPuesto());
    }
}
