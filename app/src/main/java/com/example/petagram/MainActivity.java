package com.example.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);


        setViewPager();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuactionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){

            case R.id.Cotacto:
                Intent intentC = new Intent(this, Contacto.class);
                startActivity(intentC);
                return true;
            case R.id.AcercaDe:
                Intent intentA = new Intent(this, AcercaDe.class);
                startActivity(intentA);
                return true;
            case R.id.IR:
                Intent intent = new Intent(this, MainActivity2.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public ArrayList<Fragment> AgregarFragments(){

        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new FragmentMascotas());
        fragments.add(new FragmentPerfil());

        return fragments;

    }

    public void setViewPager() {

        viewPager.setAdapter(new PageAdaptador(getSupportFragmentManager(), 0,AgregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.huellas);
        tabLayout.getTabAt(1).setIcon(R.drawable.perfil);

    }

}