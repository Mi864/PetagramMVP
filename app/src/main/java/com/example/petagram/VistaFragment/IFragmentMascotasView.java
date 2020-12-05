package com.example.petagram.VistaFragment;

import com.example.petagram.Adaptador.MascotasAdaptador;
import com.example.petagram.Mascota;

import java.util.ArrayList;

public interface IFragmentMascotasView {

    void GenerarLinearLayoutRV();
    void InicializarAdaptador(ArrayList<Mascota> mascotas);

}
