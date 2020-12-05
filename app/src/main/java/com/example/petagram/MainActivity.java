package com.example.petagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.petagram.Adaptador.PageAdaptador;
import com.example.petagram.Menu.AcercaDe;
import com.example.petagram.Menu.Contacto;
import com.example.petagram.Menu.MainActivity2;
import com.example.petagram.RestApi.Adaptador;
import com.example.petagram.RestApi.Endpoints;
import com.example.petagram.RestApi.ModeloRespuesta;
import com.example.petagram.VistaFragment.FragmentMascotas;
import com.example.petagram.VistaFragment.FragmentPerfil;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

            case R.id.RecibirNotificaciones:
                recibirNotificaciones();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void recibirNotificaciones() {

        final String TAG = "TOKEN";

        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                            return;
                        }
                        // Get new FCM registration token
                        String token = task.getResult();

                        // Log and toast
                        String msg = getString(R.string.msg_token_fmt, token);
                        Log.d(TAG, msg);
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();

                        Adaptador RestApiAdaptador      = new Adaptador();
                        Endpoints endpoints             = RestApiAdaptador.establecerConexionRestApi();
                        final Call<ModeloRespuesta> Respuesta = endpoints.registrarToken(token);

                        Respuesta.enqueue(new Callback<ModeloRespuesta>() {
                            @Override
                            public void onResponse(Call<ModeloRespuesta> call, Response<ModeloRespuesta> response) {
                                ModeloRespuesta modeloRespuesta = response.body();
                                Log.d("ID Firebase", modeloRespuesta.getId());
                                Log.d("Token Firebase", modeloRespuesta.getToken());
                            }

                            @Override
                            public void onFailure(Call<ModeloRespuesta> call, Throwable t) {

                            }
                        });

                    }
                });

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