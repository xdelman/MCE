package com.example.xolaniman_xdelman.themc_app;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

/**
 * This class is responsible for the screens with service providers, making them clickable and directing them
 * to an appropriate screen.
 *
 * @Author Delman Xolani
 * @Date 2016
 */
public class Main2Activity extends AppCompatActivity {

    //Button buttonM, buttonV, buttonC, buttonT;
    public ImageButton buttonM, buttonV, buttonC, buttonT;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        VodaClickListner();
        MTNClickListner();
        EitaClickListener();
        CellcClickListner();

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.Open, R.string.Close);

         //Creating the side menu button
        drawerLayout.setDrawerListener(actionBarDrawerToggle) ;
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    /**
     * Enabling side menu button action
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if ( actionBarDrawerToggle.onOptionsItemSelected(item) ) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    ////////////////////////////////////////Button Listeners
    public void MTNClickListner(){
        buttonM = (ImageButton) findViewById(R.id.imageButtonM);//.mtn_button);
        buttonM.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       // MTNClickDialog();     Select Dialog call
                        Intent mntIntent = new Intent("com.example.xolaniman_xdelman.themc_app.Main3Activity_menu_icons");
                        startActivity(mntIntent);
                    }
                }
        );
    }

    public void VodaClickListner(){
        buttonV = (ImageButton) findViewById(R.id.imageButtonV);//.button_voda);
        buttonV.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //VodaClickDialog(); Select Dialog call
                        Intent vodaIntent = new Intent("com.example.xolaniman_xdelman.themc_app.Main3Activity_menu_icons");
                        startActivity(vodaIntent);
                    }
                }
        );
    }

    public void CellcClickListner(){
        buttonC = (ImageButton) findViewById(R.id.imageButtonC);//.cellc_button);
        buttonC.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //CellcClickDialog(); Select Dialog call
                        Intent cellcIntent = new Intent("com.example.xolaniman_xdelman.themc_app.Main3Activity_menu_icons");
                        startActivity(cellcIntent);
                    }
                }
        );
    }

    public void EitaClickListener(){
        buttonT = (ImageButton) findViewById(R.id.imageButtonE);//.button_8ta);
        buttonT.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //EitaClickDialog();  Select Dialog call
                        Intent eitaIntent = new Intent("com.example.xolaniman_xdelman.themc_app.Main3Activity_menu_icons");
                        startActivity(eitaIntent);
                    }
                }
        );
    }

    /*
    public void MTNClickDialog(){
        ////////////////////Alert Dialog or Input Dialog code////////////////////
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Welcome Sandile, you are on MTN. Please Select your choice:");
        builder.setMessage("1. My MCE Wallet \n" +
                "2. Transactions \n" +
                "3. Notifications \n" +
                "4. MCE Rewards \n" +
                "5. About MCE version 1.0 \n" +
                "6 My MCE Account \n" +
                "7 Comments");

        //Set up input
        final EditText inputText = new EditText(this);

        //Specify expected input
        inputText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
        builder.setView(inputText);

        //Setup buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                m_Text = inputText.getText().toString();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();

    }

    public void VodaClickDialog(){

        ////////////////////Alert Dialog or Input Dialog code////////////////////
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Welcome Sandile, you are on Vodacom. Please Select your choice:");
        builder.setMessage("1. My MCE Wallet \n" +
                "2. Transactions \n" +
                "3. Notifications \n" +
                "4. MCE Rewards \n" +
                "5. About MCE version 1.0 \n" +
                "6 My MCE Account \n" +
                "7 Comments");

        //Set up input
        final EditText inputText = new EditText(this);

        //Specify expected input
        inputText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
        builder.setView(inputText);

        //Setup buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                m_Text = inputText.getText().toString();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();

    }

    public void EitaClickDialog(){

        ////////////////////Alert Dialog or Input Dialog code////////////////////
        final AlertDialog.Builder builder_Eita = new AlertDialog.Builder(this);
        builder_Eita.setTitle("Welcome Sandile, you are on Telkom mobile. Please Select your choice:");
        builder_Eita.setMessage("1. My MCE Wallet \n" +
                "2. Transactions \n" +
                "3. Notifications \n" +
                "4. MCE Rewards \n" +
                "5. About MCE version 1.0 \n" +
                "6 My MCE Account \n" +
                "7 Comments");

        //Set up input
        final EditText inputText = new EditText(this);

        //Specify expected input
        inputText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
        builder_Eita.setView(inputText);

        //Setup buttons
        builder_Eita.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                m_Text = inputText.getText().toString();
                //Call a method if option 1 is selected
                //****************************************************************************** Message shown after pressing 1

                if(m_Text.equals("1")){
                    builder_Eita.setTitle("Balance Check");
                    builder_Eita.setMessage("Your Balance is: R150.20");
                    inputText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
                    builder_Eita.setView(inputText);
                    //**************************************************
                }
                else if(m_Text.equals("0")){
                    //Call a method if option 0 is selected
                    //************************************************** Message shown after pressing 0
                    builder_Eita.setTitle("Xolani Fix This Page!!!!");
                    builder_Eita.setMessage("This must take you back to previous page");
                    inputText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
                    builder_Eita.setView(inputText);
                    //**************************************************

                }
                else {
                    builder_Eita.show();
                }
                //****************************************************************************** Message shown after pressing 1
            }
        });
        builder_Eita.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder_Eita.show();

    }

    public void CellcClickDialog(){

        ////////////////////Alert Dialog or Input Dialog code////////////////////
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Welcome Sandile, you are on Cell C. Please Select your choice:");
        builder.setMessage("1. My MCE Wallet \n" +
                "2. Transactions \n" +
                "3. Notifications \n" +
                "4. MCE Rewards \n" +
                "5. About MCE version 1.0 \n" +
                "6 My MCE Account \n" +
                "7 Comments");

        //Set up input
        final EditText inputText = new EditText(this);

        //Specify expected input
        inputText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
        builder.setView(inputText);

        //Setup buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                m_Text = inputText.getText().toString();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();

    }*/


}
