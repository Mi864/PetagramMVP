package com.example.petagram.VistaFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.petagram.Mascota;
import com.example.petagram.Adaptador.MascotasAdaptador;
import com.example.petagram.Presentador.FragmentMascotasPresentador;
import com.example.petagram.R;

import java.util.ArrayList;


public class FragmentMascotas extends Fragment implements IFragmentMascotasView{

    RecyclerView RvMascotas;
    FragmentMascotasPresentador Presentador;
    IFragmentMascotasView iFragmentMascotasView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mascotas,container,false);
        RvMascotas = v.findViewById(R.id.Rv);

        Presentador = new FragmentMascotasPresentador(iFragmentMascotasView,getContext());

        return v;
    }

    @Override
    public void GenerarLinearLayoutRV() {

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        RvMascotas.setLayoutManager(llm);
    }

    @Override
    public void InicializarAdaptador(ArrayList<Mascota> mascotas) {

        MascotasAdaptador adaptador = new MascotasAdaptador(mascotas, getActivity());
        RvMascotas.setAdapter(adaptador);
    }
}