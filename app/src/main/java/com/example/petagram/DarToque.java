package com.example.petagram;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.petagram.RestApi.Adaptador;
import com.example.petagram.RestApi.Endpoints;
import com.example.petagram.RestApi.ModeloRespuesta;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DarToque extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        String id = "123";
        String receptor = "";
        Adaptador RestApiAdaptador  = new Adaptador();
        Endpoints endpoints         = RestApiAdaptador.establecerConexionRestApi();
        final Call<ModeloRespuesta> Respuesta = endpoints.darToque(id,receptor);

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
}
