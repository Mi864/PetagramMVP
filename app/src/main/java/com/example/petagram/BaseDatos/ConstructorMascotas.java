package com.example.petagram.BaseDatos;

import android.content.ContentValues;
import android.content.Context;

import com.example.petagram.Mascota;
import com.example.petagram.R;

import java.util.ArrayList;

public class ConstructorMascotas {


    Context context;

    public ConstructorMascotas(Context context) {

        this.context = context;
    }

    public void insertarDatos(BaseDatos baseDatos){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TablaMascotaNombre,"Tommy");
        contentValues.put(ConstantesBaseDatos.TablaMascotaFoto,R.drawable.p1);

        baseDatos.InsertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TablaMascotaNombre,"Luna");
        contentValues.put(ConstantesBaseDatos.TablaMascotaFoto,R.drawable.p2);

        baseDatos.InsertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TablaMascotaNombre,"Toby");
        contentValues.put(ConstantesBaseDatos.TablaMascotaFoto,R.drawable.p3);

        baseDatos.InsertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TablaMascotaNombre,"Perla");
        contentValues.put(ConstantesBaseDatos.TablaMascotaFoto,R.drawable.p4);

        baseDatos.InsertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TablaMascotaNombre,"Max");
        contentValues.put(ConstantesBaseDatos.TablaMascotaFoto,R.drawable.p5);

        baseDatos.InsertarMascotas(contentValues);
    }
    public ArrayList<Mascota> obtenerDatos(){

        BaseDatos baseDatos = new BaseDatos(context);
        insertarDatos(baseDatos);
        return baseDatos.ObtenerMascotas();

       /* ArrayList<Mascota> mascotas = new ArrayList<>();

        mascotas.add(new Mascota(R.drawable.p1,"Tommy",1));
        mascotas.add(new Mascota(R.drawable.p2,"Luna" ,1));
        mascotas.add(new Mascota(R.drawable.p3,"Toby" ,1));
        mascotas.add(new Mascota(R.drawable.p4,"Perla",1));
        mascotas.add(new Mascota(R.drawable.p5,"Max"  ,1));

        return mascotas;*/
    }
}
