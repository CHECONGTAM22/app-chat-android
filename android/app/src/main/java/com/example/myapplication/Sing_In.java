package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.api.API_Sign_In;
import com.example.myapplication.model.Sing_in;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Sing_In extends AppCompatActivity {
    private EditText mName,mPassword;
    private Button mbtok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);
        mName=findViewById(R.id.edt_user);
        mPassword=findViewById(R.id.edt_password);
        mbtok=findViewById(R.id.bt_ok);

        mbtok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callAPi();
            }
        });
    }

    private void callAPi() {
        String name=mName.getText().toString().trim();
        String pass=mPassword.getText().toString().trim();
        RequestBody requestBodyName=RequestBody.create(MediaType.parse("multipart/form-data"),name);
        RequestBody requestBodyPassword=RequestBody.create(MediaType.parse("multipart/form-data"),pass);
        API_Sign_In.API_SIGN_IN.SING_IN_CALL(requestBodyName,requestBodyPassword).enqueue(new Callback<Sing_in>() {
            @Override
            public void onResponse(Call<Sing_in> call, Response<Sing_in> response) {
                Toast.makeText(Sing_In.this,"post thanh cong",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Sing_in> call, Throwable t) {
                Toast.makeText(Sing_In.this,"post khong thanh cong",Toast.LENGTH_SHORT).show();
            }
        });
    }
}