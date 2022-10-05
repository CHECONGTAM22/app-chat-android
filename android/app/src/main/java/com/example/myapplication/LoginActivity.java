package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.api.ApiService;
import com.example.myapplication.model.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText edUsername;
    private EditText edPassword;
    private Button btLogin;
    private List<User> mlistuser;
    private User mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUsername=findViewById(R.id.edt_user);
        edPassword=findViewById(R.id.edt_pass);
        btLogin=findViewById(R.id.bt_login);
        mlistuser =new ArrayList<>();
        getListUser();
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickLogin();
            }
        });
    }
    private void clickLogin() {
        String stUsername = edUsername.getText().toString().trim();
        String stpass = edPassword.getText().toString().trim();

        if (mlistuser == null || mlistuser.isEmpty()) {
            return;
        }
        boolean hasUser = false;
        for (User user : mlistuser) {
            if (stUsername.equals(user.getUsername()) && stpass.equals(user.getPassword())) {
                hasUser=true;
                mUser=user;
                break;
            }
        }
        if (hasUser==true){
            Toast.makeText(LoginActivity.this,"than cong ",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(LoginActivity.this,test.class);
            Bundle bundle=new Bundle();
            bundle.putSerializable("objet_user",mUser);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        else {
            Toast.makeText(LoginActivity.this,"fale" , Toast.LENGTH_SHORT).show();
        }
    }
    private void getListUser(){
        ApiService.apiservice.getlistuser().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                mlistuser=response.body();
                Log.v("list user ",mlistuser.size()+"");
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(LoginActivity.this,"that bai",Toast.LENGTH_SHORT).show();
            }
        });
    }
}