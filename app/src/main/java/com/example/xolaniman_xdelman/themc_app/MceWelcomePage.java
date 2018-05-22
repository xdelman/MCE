package com.example.xolaniman_xdelman.themc_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MceWelcomePage extends AppCompatActivity {

    private ImageButton buttonWelcomePg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mce_welcome_page);
        WelcomePgClick();
    }

    public void WelcomePgClick(){
        buttonWelcomePg = (ImageButton) findViewById(R.id.imbutton_welcome_pg);
        buttonWelcomePg.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent registerIntent = new Intent("com.example.xolaniman_xdelman.themc_app.MainActivity");
                        startActivity(registerIntent);
                    }
                }
        );
    }
}
