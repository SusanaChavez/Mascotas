package com.monti.mascotas.pojo;

public class Mascota {
    private String nombre;
    private int foto;
    private int tantos;


    public Mascota(String nombre, int foto) {
        this.nombre = nombre;
        this.foto = foto;
        this.tantos = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getTantos() {
        return tantos;
    }

    public void setTantos() {
        this.tantos += 1;
    }
}
