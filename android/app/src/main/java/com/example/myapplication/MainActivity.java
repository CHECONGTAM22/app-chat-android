package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Adapter.ListUserAdapter;
import com.example.myapplication.api.Api_ListUser;
import com.example.myapplication.model.ListUser;
import com.example.myapplication.model.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<ListUser> mlistuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rcv);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView.ItemDecoration itemDecoration=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        mlistuser=new ArrayList<>();
        callApiListUser();
    }
    private void callApiListUser(){
        Api_ListUser.API_LIST_USER.Get_API_LIST_USER().enqueue(new Callback<List<ListUser>>() {
            @Override
            public void onResponse(Call<List<ListUser>> call, Response<List<ListUser>> response) {
                mlistuser=response.body();
                ListUserAdapter listUserAdapter=new ListUserAdapter(mlistuser);
                recyclerView.setAdapter(listUserAdapter);
            }
            @Override
            public void onFailure(Call<List<ListUser>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"toang",Toast.LENGTH_SHORT).show();
            }
        });
    }
}