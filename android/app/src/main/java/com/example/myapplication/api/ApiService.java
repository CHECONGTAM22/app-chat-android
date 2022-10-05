package com.example.myapplication.api;

import com.example.myapplication.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    // api :https://633c25d474afaef16402fba1.mockapi.io/api/users
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    ApiService apiservice = new Retrofit.Builder().baseUrl("https://633c25d474afaef16402fba1.mockapi.io/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);
    @GET("api/users")
    Call<List<User>> getlistuser();
}