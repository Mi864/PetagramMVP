package com.example.petagram.RestApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Adaptador {

    public Endpoints establecerConexionRestApi(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.URL_Servidor)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Endpoints.class);
    }
}
