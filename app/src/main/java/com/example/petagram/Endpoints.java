package com.example.petagram.RestApi;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Endpoints {

    @FormUrlEncoded
    @POST (value = ConstantesRestApi.PATH_Token)
    Call<ModeloRespuesta> registrarToken (@Field("token") String token);
}
