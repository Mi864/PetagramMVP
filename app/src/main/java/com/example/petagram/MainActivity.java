package com.example.petagram;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView RvMascotas;
    ArrayList<Mascota> mascotas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RvMascotas = findViewById(R.id.Rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        RvMascotas.setLayoutManager(llm);

        InicializarListaMascotas();
        InicializarAdaptador();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuactionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
        return true;
    }

    public void InicializarListaMascotas(){

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.p1,"Tommy"));
        mascotas.add(new Mascota(R.drawable.p2,"Luna" ));
        mascotas.add(new Mascota(R.drawable.p3,"Toby" ));
        mascotas.add(new Mascota(R.drawable.p4,"Perla"));
        mascotas.add(new Mascota(R.drawable.p5,"Max"  ));
    }

    private void InicializarAdaptador() {

        MascotasAdaptador adaptador = new MascotasAdaptador(mascotas, this);
        RvMascotas.setAdapter(adaptador);
    }

}