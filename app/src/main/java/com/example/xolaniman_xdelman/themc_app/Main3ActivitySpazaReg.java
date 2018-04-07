package com.example.xolaniman_xdelman.themc_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Main3ActivitySpazaReg extends AppCompatActivity {

    ImageButton nextStepButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3_activity_spaza_reg);
        NextStepButton();
    }

    public void NextStepButton() {
        nextStepButton = (ImageButton) findViewById(R.id.spaza_reg_pg1_imgButton1);
        nextStepButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent registerIntent = new Intent("com.example.xolaniman_xdelman.themc_app.Main3ActivitySpazaRegPg2");
                        startActivity(registerIntent);
                    }
                }
        );
    }
}
