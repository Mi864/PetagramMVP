package com.example.petagram;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class FragmentMascotas extends Fragment {

    RecyclerView RvMascotas;
    ArrayList<Mascota> mascotas;

    /*public FragmentMascotas() {
        // Required empty public constructor
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mascotas,container,false);

        RvMascotas = v.findViewById(R.id.Rv);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        RvMascotas.setLayoutManager(llm);

        InicializarListaMascotas();
        InicializarAdaptador();

        return v;
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

        MascotasAdaptador adaptador = new MascotasAdaptador(mascotas, getActivity());
        RvMascotas.setAdapter(adaptador);
    }
}