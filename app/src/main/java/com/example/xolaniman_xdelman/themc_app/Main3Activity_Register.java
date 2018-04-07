package com.example.xolaniman_xdelman.themc_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Main3Activity_Register extends AppCompatActivity {

    public ImageButton userReg, spazaReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3_activity__register);
        onClickListnerRegUser();
        onClickListnerRegSpaza();
    }

    public void onClickListnerRegUser(){
        userReg = (ImageButton) findViewById(R.id.imbutton_User_Reg);
        userReg.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent_User_Reg = new Intent("com.example.xolaniman_xdelman.themc_app.Main3Activity_User_Reg");
                        startActivity(intent_User_Reg);
                    }
                }
        );
     }

    public void onClickListnerRegSpaza(){
        spazaReg = (ImageButton) findViewById(R.id.imbutton_Spaza_Reg);
        spazaReg.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent_Spaza_Reg = new Intent("com.example.xolaniman_xdelman.themc_app.Main3ActivitySpazaReg");
                        startActivity(intent_Spaza_Reg);
                    }
                }
        );
    }
}
