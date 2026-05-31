package org.example.model;

public class Copia implements Mostrable {
    private int id;
    private String nombre;
    private String tipo;
    private String editorial;
    private int ano;
    private String autor;
    private String estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Copia(int id, String nombre, String tipo, String editorial, int ano, String autor, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.editorial = editorial;
        this.ano = ano;
        this.autor = autor;
        this.estado = estado;
    }

    @Override
    public void mostrarDatos() {
        System.out.println(getId() + " - " + getNombre() + " - " + getTipo() + " - " + getEditorial()+ " - " + getAno() + " - " + getAutor() + " - " + getEstado());
    }


}
