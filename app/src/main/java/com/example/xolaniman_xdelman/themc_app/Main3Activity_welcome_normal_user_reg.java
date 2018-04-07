package com.example.xolaniman_xdelman.themc_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Main3Activity_welcome_normal_user_reg extends AppCompatActivity {

    public ImageButton backToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3_activity_welcome_normal_user_reg);
        backToLoginListener();
    }

    public void backToLoginListener(){
        backToLogin = (ImageButton)findViewById(R.id.imageButton4);
        backToLogin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent backToLoginIntent = new Intent("com.example.xolaniman_xdelman.themc_app.MainActivity");
                        startActivity(backToLoginIntent);
                    }
                }
        );
    }
}
