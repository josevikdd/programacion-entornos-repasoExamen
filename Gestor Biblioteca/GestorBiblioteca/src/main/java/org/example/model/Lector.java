package org.example.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Lector extends Persona implements Mostrable {
    private LocalDate multaHasta;
    private ArrayList<Copia> copiasPrestadas;

    public LocalDate getMultaHasta() {
        return multaHasta;
    }

    public void setMultaHasta(LocalDate multaHasta) {
        this.multaHasta = multaHasta;
    }

    public ArrayList<Copia> getCopiasPrestadas() {
        return copiasPrestadas;
    }

    public void setCopiasPrestadas(ArrayList<Copia> copiasPrestadas) {
        this.copiasPrestadas = copiasPrestadas;
    }

    public Lector(String dni, String nombre, LocalDate multaHasta) {
        super(dni, nombre);
        this.multaHasta = multaHasta;
        this.copiasPrestadas = new ArrayList<>();
    }

    @Override
    public void mostrarDatos() {
        System.out.println("DNI: " + getDni() +  " Nombre: " + getNombre());
    }
}
