package com.example.petagram.VistaFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.petagram.Mascota;
import com.example.petagram.Adaptador.PerfilAdaptador;
import com.example.petagram.R;

import java.util.ArrayList;

public class FragmentPerfil extends Fragment {

    ImageView ImagenPerfil;
    TextView  NombrePerfil;
    RecyclerView RvPerfil;
    ArrayList<Mascota> mascota;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        ImagenPerfil = v.findViewById(R.id.ImagenP);
        NombrePerfil = v.findViewById(R.id.NombreP);
        RvPerfil = v.findViewById(R.id.RvP);

        GridLayoutManager glm = new GridLayoutManager(getContext(),3);
        RvPerfil.setLayoutManager(glm);

        InicializarListaMascotas();
        InicializarAdaptador();



        // Inflate the layout for this fragment
        return v;
    }

    public void InicializarListaMascotas(){

        mascota = new ArrayList<>();

        for (int i = 0 ; i < 15; i++ ) {
            mascota.add(new Mascota(R.drawable.p1, "Tommy"));
        }
    }

    private void InicializarAdaptador() {

        PerfilAdaptador adaptador = new PerfilAdaptador(mascota, getActivity());
        RvPerfil.setAdapter(adaptador);
    }

}