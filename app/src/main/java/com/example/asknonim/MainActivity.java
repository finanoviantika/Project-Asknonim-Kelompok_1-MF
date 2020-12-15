package com.example.asknonim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Tampilan(views)
    Button mRegisterBtn, mLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init views
        mRegisterBtn = findViewById(R.id.register_btn);
        mLoginBtn = findViewById(R.id.login_btn);

        //handle register button click
        mRegisterBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                //start register activity
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });
        //handle login button
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //start login activity
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });
    }
}