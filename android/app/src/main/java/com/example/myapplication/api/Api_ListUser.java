package com.example.myapplication.api;

import com.example.myapplication.model.ListUser;
import com.example.myapplication.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface Api_ListUser {
    // api :https://633c25d474afaef16402fba1.mockapi.io/api/ListUer
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    Api_ListUser API_LIST_USER = new Retrofit.Builder().baseUrl("https://633c25d474afaef16402fba1.mockapi.io")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(Api_ListUser.class);
    @GET("/api/ListUer")
    Call<List<ListUser>> Get_API_LIST_USER();
}
