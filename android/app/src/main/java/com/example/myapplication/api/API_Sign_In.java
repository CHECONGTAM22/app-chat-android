package com.example.myapplication.api;

import com.example.myapplication.model.Sing_in;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface API_Sign_In {

    public static final String DOMAIN="https://633c25d474afaef16402fba1.mockapi.io/api/users";
    Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    API_Sign_In API_SIGN_IN=new Retrofit.Builder()
            .baseUrl(DOMAIN)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(API_Sign_In.class);
    @Multipart
    @POST
    Call<Sing_in> SING_IN_CALL(@Part(Const.KEY_USERNAME)RequestBody username,
                               @Part(Const.KEY_PASSWORD)RequestBody paswword);
}
