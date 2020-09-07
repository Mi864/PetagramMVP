package com.example.petagram;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    RecyclerView RvMascotas;
    ArrayList<Mascota> mascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       // getSupportActionBar().setDisplayShowHomeEnabled(true);

        RvMascotas = findViewById(R.id.Rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        RvMascotas.setLayoutManager(llm);

        InicializarListaMascotas();
        InicializarAdaptador();

    }

    public void InicializarListaMascotas(){

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.p2,"Luna" ));
        mascotas.add(new Mascota(R.drawable.p4,"Perla"));
        mascotas.add(new Mascota(R.drawable.p3,"Toby" ));
        mascotas.add(new Mascota(R.drawable.p5,"Max"  ));
        mascotas.add(new Mascota(R.drawable.p1,"Tommy"));
    }

    private void InicializarAdaptador() {

        MascotasAdaptador adaptador = new MascotasAdaptador(mascotas, this);
        RvMascotas.setAdapter(adaptador);
    }

}
