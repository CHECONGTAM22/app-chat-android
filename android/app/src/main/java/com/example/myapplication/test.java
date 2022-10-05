package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.model.User;

public class test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        TextView tvUser=findViewById(R.id.id_tv);
        Bundle bundle=getIntent().getExtras();
        if (bundle!=null) {
            User user = (User) bundle.get("objet_user");
            if (user != null){
                tvUser.setText(user.toString());
            }
        }
    }
}