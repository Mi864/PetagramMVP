package com.example.petagram;

public class Mascota {

    int Foto;
    String Nombre;


    public Mascota(int foto, String nombre) {
        this.Foto = foto;
        this.Nombre = nombre;
    }

    public int getFoto() {
        return Foto;
    }

    public void setFoto(int foto) {
        Foto = foto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

}
