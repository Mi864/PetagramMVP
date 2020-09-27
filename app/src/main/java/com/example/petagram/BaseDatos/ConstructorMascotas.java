package com.example.petagram.BaseDatos;

import android.content.Context;

import com.example.petagram.Mascota;
import com.example.petagram.R;

import java.util.ArrayList;

public class ConstructorMascotas {


    Context context;

    public ConstructorMascotas(Context context) {

        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){

        ArrayList<Mascota> mascotas = new ArrayList<>();

        mascotas.add(new Mascota(R.drawable.p1,"Tommy",1));
        mascotas.add(new Mascota(R.drawable.p2,"Luna" ,1));
        mascotas.add(new Mascota(R.drawable.p3,"Toby" ,1));
        mascotas.add(new Mascota(R.drawable.p4,"Perla",1));
        mascotas.add(new Mascota(R.drawable.p5,"Max"  ,1));

        return mascotas;
    }
}
