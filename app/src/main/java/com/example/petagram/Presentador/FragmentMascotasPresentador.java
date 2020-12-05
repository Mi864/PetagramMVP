package com.example.petagram.Presentador;

import android.content.Context;

import com.example.petagram.BaseDatos.ConstructorMascotas;
import com.example.petagram.Mascota;
import com.example.petagram.VistaFragment.IFragmentMascotasView;

import java.util.ArrayList;

public class FragmentMascotasPresentador implements IFragmentMascotasPresentador {

    IFragmentMascotasView iFragmentMascotasView;
    Context context;
    ConstructorMascotas constructorMascotas;
    ArrayList<Mascota> mascotas;

    public FragmentMascotasPresentador(IFragmentMascotasView iFragmentMascotasView, Context context) {

        this.iFragmentMascotasView = iFragmentMascotasView;
        this.context = context;
        obtenerMascotasBD();
    }

    @Override
    public void obtenerMascotasBD() {
    constructorMascotas = new ConstructorMascotas(context);
    mascotas = constructorMascotas.obtenerMascotas();
    mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
    iFragmentMascotasView.InicializarAdaptador(mascotas);
    iFragmentMascotasView.GenerarLinearLayoutRV();
    }
}
