
package com.example.xolaniman_xdelman.themc_app;

import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.helpers.InputValidation;
import com.model.MCE_User;
import com.sql.DatabaseHelperLogin;

public class Main3Activity_User_Reg extends AppCompatActivity implements View.OnClickListener {
    private final AppCompatActivity activity = Main3Activity_User_Reg.this;

    private NestedScrollView nestedScrollView;

    private TextInputLayout     textInputLayoutFirstName;
    private TextInputLayout     textInputLayoutLastName;
    private TextInputLayout     textInputLayoutPhoneNumber;
    private TextInputLayout     textInputLayoutEmail;
    private TextInputLayout     textInputLayoutPassword;
    private TextInputLayout     textInputLayoutConfirmPassword;

    private TextInputEditText   textInputEditTextFirstName;
    private TextInputEditText   textInputEditTextLastName;
    private TextInputEditText   textInputEditTextPhoneNumber;
    private TextInputEditText   textInputEditTextEmail;
    private TextInputEditText   textInputEditTextPassword;
    private TextInputEditText   textInputEditTextConfirmPassword;

    private AppCompatButton     appCompatButtonRegister;
    private AppCompatTextView   appCompatTextViewLoginLink;

    private InputValidation     inputValidation;
    private DatabaseHelperLogin databaseHelper;
    private MCE_User            user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3_activity__user__reg);

        getSupportActionBar().hide();

        initViews();
        initListeners();
        initObjects();
    }

    /**
     * This method is to initialize views
     */
    private void initViews() {
        nestedScrollView                  = (NestedScrollView) findViewById(R.id.nestedScrollView);

        textInputLayoutFirstName          = (TextInputLayout) findViewById(R.id.textInputLayoutFirstName);
        textInputLayoutLastName           = (TextInputLayout) findViewById(R.id.textInputLayoutLastName);
        textInputLayoutPhoneNumber        = (TextInputLayout) findViewById(R.id.textInputLayoutPhoneNumber);
        textInputLayoutEmail              = (TextInputLayout) findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword           = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);
        textInputLayoutConfirmPassword    = (TextInputLayout) findViewById(R.id.textInputLayoutConfirmPassword);

        textInputEditTextFirstName        = (TextInputEditText) findViewById(R.id.textInputEditTextFirstName);
        textInputEditTextLastName         = (TextInputEditText) findViewById(R.id.textInputEditTextLastName);
        textInputEditTextPhoneNumber      = (TextInputEditText) findViewById(R.id.textInputEditTextPhoneNumber);
        textInputEditTextEmail            = (TextInputEditText) findViewById(R.id.textInputEditTextEmail);
        textInputEditTextPassword         = (TextInputEditText) findViewById(R.id.textInputEditTextPassword);
        textInputEditTextConfirmPassword  = (TextInputEditText) findViewById(R.id.textInputEditTextConfirmPassword);

        appCompatButtonRegister           = (AppCompatButton) findViewById(R.id.appCompatButtonRegister);

        appCompatTextViewLoginLink        = (AppCompatTextView) findViewById(R.id.appCompatTextViewLoginLink);
    }

    /**
     * This method is to initialize listeners
     */
    private void initListeners() {
        appCompatButtonRegister.setOnClickListener(this);
        appCompatTextViewLoginLink.setOnClickListener(this);
    }

    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {
        inputValidation = new InputValidation(activity);
        databaseHelper = new DatabaseHelperLogin(activity);
        user = new MCE_User();
    }

    /**
     * This implemented method is to listen the click on view
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.appCompatButtonRegister:
                postDataToSQLite();
                break;

            case R.id.appCompatTextViewLoginLink:
                finish();
                break;
        }
    }

    /**
     * This method is to validate the input text fields and post data to SQLite
     */
    private void postDataToSQLite() {
        if (!inputValidation.isInputEditTextFilled(textInputEditTextFirstName, textInputLayoutFirstName, getString(R.string.error_message_first_name))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextLastName, textInputLayoutLastName, getString(R.string.error_message_last_name))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextPhoneNumber, textInputLayoutPhoneNumber, getString(R.string.error_message_phone_number))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextEmail(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextPassword, textInputLayoutPassword, getString(R.string.error_message_password))) {
            return;
        }
        if (!inputValidation.isInputEditTextMatches(textInputEditTextPassword, textInputEditTextConfirmPassword,
                textInputLayoutConfirmPassword, getString(R.string.error_password_match))) {
            return;
        }

        if (!databaseHelper.checkUser(textInputEditTextEmail.getText().toString().trim())) {

            user.setFirstName(textInputEditTextFirstName.getText().toString().trim());
            user.setLastName(textInputEditTextLastName.getText().toString().trim());
            user.setPhoneNumber(textInputEditTextPhoneNumber.getText().toString().trim());
            user.setEmail(textInputEditTextEmail.getText().toString().trim());
            user.setPassword(textInputEditTextPassword.getText().toString().trim());

            databaseHelper.addUser(user);

            // Snack Bar to show success message that record saved successfully
            Snackbar.make(nestedScrollView, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
            emptyInputEditText();


        } else {
            // Snack Bar to show error message that record already exists
            Snackbar.make(nestedScrollView, getString(R.string.error_email_exists), Snackbar.LENGTH_LONG).show();
        }
    }

    /**
     * This method is to empty all input edit text
     */
    private void emptyInputEditText() {
        textInputEditTextFirstName.setText(null);
        textInputEditTextLastName.setText(null);
        textInputEditTextPhoneNumber.setText(null);
        textInputEditTextEmail.setText(null);
        textInputEditTextPassword.setText(null);
        textInputEditTextConfirmPassword.setText(null);
    }
}
