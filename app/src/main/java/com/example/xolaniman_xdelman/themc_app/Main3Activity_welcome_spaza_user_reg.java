package com.example.xolaniman_xdelman.themc_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Main3Activity_welcome_spaza_user_reg extends AppCompatActivity {

    public ImageButton backToLoginS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3_activity_welcome_spaza_user_reg);
        backToLoginSClickListener();
    }

    public void backToLoginSClickListener(){
        backToLoginS = (ImageButton)findViewById(R.id.imageButton4);
        backToLoginS.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent backToLoginSIntent = new Intent("com.example.xolaniman_xdelman.themc_app.MainActivity");
                        startActivity(backToLoginSIntent);
                    }
                }
        );
    }
}
