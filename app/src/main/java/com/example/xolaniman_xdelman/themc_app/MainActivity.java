package com.example.xolaniman_xdelman.themc_app;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.helpers.InputValidation;
import com.sql.DatabaseHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonM, buttonV, buttonC, buttonT, network_check;
    private ImageButton buttonLogin, buttonRegister;
    ConnectionDetector cd;
    private String m_Text="";

    //Start Validation Declaration*****************************************
    private final AppCompatActivity activity = MainActivity.this;

    private NestedScrollView nestedScrollView;

    private EditText textEditTextUsername;
    private EditText textEditTextPassword;

    private ImageButton imageButtonLogin;
    private ImageButton imageButtonRegister;

    private TextInputLayout textInputLayoutUsername;
    private TextInputLayout textInputLayoutPassword;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;
    //End Validation Declaration*******************************************

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Start Validation Declaration*****************************************
        getSupportActionBar().hide();  //Check difference caused by this method

        //End Validation Declaration*******************************************


        //onClickListner();

        //LoginClick();    Previous Called Method****************************
        //RegistrationClick();   Previous Called Method****************************

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    //Start Validation Methods*****************************************
    /**
     * This method is to initialize views
     */
    private void initViews() {

        textEditTextUsername = (EditText) findViewById(R.id.editText);
        textEditTextPassword = (EditText) findViewById(R.id.editText3);

        imageButtonLogin = (ImageButton) findViewById(R.id.imbutton_login);
        imageButtonRegister = (ImageButton) findViewById(R.id.imbutton_register);


    }

    /**
     * This method is to initialize listeners
     */
    private void initListeners() {
        imageButtonLogin.setOnClickListener((View.OnClickListener) this);
        imageButtonRegister.setOnClickListener((View.OnClickListener) this);
    }

    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {
        databaseHelper = new DatabaseHelper(activity);
        inputValidation = new InputValidation(activity);
    }

    /**
     * This implemented method is to listen the click on view
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imbutton_login:
                //verifyFromSQLite();
                //Call this Intent for now, change later to call the verifyFromSQLite() method above
                Intent loginIntent = new Intent("com.example.xolaniman_xdelman.themc_app.Main2Activity");
                startActivity(loginIntent);
                //Call this Intent for now, change later to call the verifyFromSQLite() method
                break;
            case R.id.imbutton_register:
                // Navigate to RegisterActivity
                Intent intentRegister = new Intent(getApplicationContext(), Main3Activity_Register.class);
                startActivity(intentRegister);
                break;
        }
    }

    /**
     * This method is to validate the input text fields and verify login credentials from SQLite
     */
    private void verifyFromSQLite() {
        //if (!inputValidation.isInputEditTextFilled(textEditTextUsername, textInputLayoutEmail, getString(R.string.error_message_email))) {
        //    return;
        //}
        if (!inputValidation.isInputEditTextEmail(textEditTextUsername, textInputLayoutUsername, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textEditTextPassword, textInputLayoutPassword, getString(R.string.error_message_email))) {
            return;
        }

        //f (databaseHelper.checkUser(textEditTextUsername.getText().toString().trim()
       //         , textEditTextPassword.getText().toString().trim())) {
        if (databaseHelper.checkUser(textEditTextUsername.getText().toString().trim())) {


                Intent accountsIntent = new Intent(activity, UsersListActivity.class);
                accountsIntent.putExtra("UNSERNAME", textEditTextUsername.getText().toString().trim());
                emptyInputEditText();
                startActivity(accountsIntent);


            } else {
                // Snack Bar to show success message that record is wrong
                Snackbar.make(nestedScrollView, getString(R.string.error_message_password), Snackbar.LENGTH_LONG).show();
            }
        }

    /**
     * This method is to empty all input edit text
     */
    private void emptyInputEditText() {
        textEditTextUsername.setText(null);
        textEditTextPassword.setText(null);
    }

    //End Validation Methods*****************************************

/*
    public void NetCheck(){
        network_check = (Button)findViewById(R.id.button_forget);
        cd = new ConnectionDetector(this);
        network_check.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(cd.isConnected()){
                            Toast.makeText(MainActivity.this, "Connected", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this, "Not Connected", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }*/

/********************************************************************************************Start Previous Working Code

    public void LoginClick() {
        final EditText username = (EditText)findViewById(R.id.editText);
        final EditText password = (EditText)findViewById(R.id.editText3);

        buttonLogin = (ImageButton) findViewById(R.id.imbutton_login);
        buttonLogin.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if ( (username.getText().toString().equals("admin")) && (password.getText().toString().equals("admin"))){
                            Log.v("EditText_Password", password.getText().toString());
                                //if(R.id.editText );
                                Intent loginIntent = new Intent("com.example.xolaniman_xdelman.themc_app.Main2Activity");
                                startActivity(loginIntent);
                            } else {
                                loginFailed();
                            }
                        }
                    }
            );
    }

    public void RegistrationClick(){
        buttonRegister = (ImageButton) findViewById(R.id.imbutton_register);
        buttonRegister.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent registerIntent = new Intent("com.example.xolaniman_xdelman.themc_app.Main3Activity_Register");
                        startActivity(registerIntent);
                    }
                }
        );
    }


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.xolaniman_xdelman.themc_app/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.xolaniman_xdelman.themc_app/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    public void loginFailed(){
        ////////////////////Alert Dialog or Input Dialog code////////////////////
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Login Failed!");
        builder.setMessage("Incorrect Username or Password. Please try to login again!");

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
    ********************************************************************************************End Previous Working Code*/



}
