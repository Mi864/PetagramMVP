package com.example.petagram.BaseDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.petagram.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    Context context;

    public BaseDatos(@Nullable Context context) {

        super(context,ConstantesBaseDatos.NombreBD,null,ConstantesBaseDatos.VersionBD);
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String queryCrearTablaMascota = "CREATE TABLE "+ ConstantesBaseDatos.TablaMascota + "(" +

                ConstantesBaseDatos.TablaMascotaID     + "INTEGER PRIMARY KEY AUTOINCREMENT," +
                ConstantesBaseDatos.TablaMascotaNombre + "TEXT,"   +
                ConstantesBaseDatos.TablaMascotaFoto   + "INTEGER" +

                ")";

        String queryCrearTablaLikesMascota = "CREATE TABLE "+ ConstantesBaseDatos.TablaLikesMascota + "(" +

                ConstantesBaseDatos.TablaLikesMascotaID        + "INTEGER PRIMARY KEY AUTOINCREMENT," +
                ConstantesBaseDatos.TablaLikesMascotaMascotaID + "INTEGER," +
                ConstantesBaseDatos.TablaLikesMascotaLikes     + "INTEGER," +

                "FOREIGN KEY (" + ConstantesBaseDatos.TablaLikesMascotaMascotaID + ") " +
                "REFERENCES "+ ConstantesBaseDatos.TablaMascota + "(" + ConstantesBaseDatos.TablaMascotaID + ")"+
                ")";

        sqLiteDatabase.execSQL(queryCrearTablaMascota);
        sqLiteDatabase.execSQL(queryCrearTablaLikesMascota);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ ConstantesBaseDatos.TablaMascota);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ ConstantesBaseDatos.TablaLikesMascota);
        onCreate(sqLiteDatabase);
    }

    public void InsertarMascotas(ContentValues contentValues){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(ConstantesBaseDatos.TablaMascota,null,contentValues);
        sqLiteDatabase.close();

    }

    public ArrayList<Mascota> ObtenerMascotas(){

        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT*FROM " + ConstantesBaseDatos.TablaMascota;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        Cursor registros = sqLiteDatabase.rawQuery(query,null);

        while (registros.moveToNext()){

            Mascota mascota = new Mascota();

            mascota.setId(registros.getInt(0));//Campo ID el cual se autoincrementa
            mascota.setNombre(registros.getString(1));
            mascota.setFoto(registros.getInt(2));

            String querylikes = "SELECT COUNT(" + ConstantesBaseDatos.TablaLikesMascotaLikes + ")" +
                                " FROM "  + ConstantesBaseDatos.TablaLikesMascota +
                                " WHERE " + ConstantesBaseDatos.TablaLikesMascotaMascotaID + "=" + mascota.getId();

            Cursor registroslikes = sqLiteDatabase.rawQuery(querylikes,null);

            if (registroslikes.moveToNext()){
                mascota.setLike(registroslikes.getInt(0));
            }else
                mascota.setLike(0);

            mascotas.add(mascota);
        }

        sqLiteDatabase.close();
        return mascotas;
    }

    public void InsertarLikesMascota(ContentValues contentValues){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(ConstantesBaseDatos.TablaLikesMascota,null,contentValues);
        sqLiteDatabase.close();

    }

    public int ObtenerLikesMascota(Mascota mascota){

        int likes = 0;

        String query = "SELECT COUNT(" + ConstantesBaseDatos.TablaLikesMascotaLikes + ")" +
                       " FROM "  + ConstantesBaseDatos.TablaLikesMascota +
                       " WHERE " + ConstantesBaseDatos.TablaLikesMascotaMascotaID + "=" + mascota.getId();

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor registros = sqLiteDatabase.rawQuery(query,null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }

        sqLiteDatabase.close();

        return likes;
    }
}
