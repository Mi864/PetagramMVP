package com.example.petagram;

public class Mascota {

    int id;
    int Foto;
    String Nombre;
    int Likes;

    public Mascota(int foto, String nombre, int likes) {
        this.Foto   = foto;
        this.Nombre = nombre;
        this.Likes  = likes;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLikes() {
        return Likes;
    }

    public void setLikes(int likes) {
        Likes = likes;
    }


}
