package com.example.xolaniman_xdelman.themc_app;

import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.helpers.InputValidation;
import com.model.MCE_Agent;
import com.sql.DatabaseHelperLogin;
import com.sql.DatabaseHelperLoginAgent;

public class Main3ActivitySpazaReg extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = Main3ActivitySpazaReg.this;

    private NestedScrollView         nestedScrollView;

    private TextInputLayout          textInputLayoutAgentFirstName;
    private TextInputLayout          textInputLayoutAgentLastName;
    private TextInputLayout          textInputLayoutAgentPhoneNumber;
    private TextInputLayout          textInputLayoutAgentStoreName;
    private TextInputLayout          textInputLayoutAgentStoreAddress;
    private TextInputLayout          textInputLayoutAgentStoreRegNumber;
    private TextInputLayout          textInputLayoutAgentStoreAccNumber;
    private TextInputLayout          textInputLayoutAgentStoreBank;
    private TextInputLayout          textInputLayoutAgentEmail;
    private TextInputLayout          textInputLayoutAgentPassword;
    private TextInputLayout          textInputLayoutAgentConfirmPassword;

    private TextInputEditText        textInputEditTextAgentFirstName;
    private TextInputEditText        textInputEditTextAgentLastName;
    private TextInputEditText        textInputEditTextAgentPhoneNumber;
    private TextInputEditText        textInputEditTextAgentStoreName;
    private TextInputEditText        textInputEditTextAgentStoreAddress;
    private TextInputEditText        textInputEditTextAgentStoreRegNumber;
    private TextInputEditText        textInputEditTextAgentStoreAccNumber;
    private TextInputEditText        textInputEditTextAgentEmail;
    private TextInputEditText        textInputEditTextAgentPassword;
    private TextInputEditText        textInputEditTextAgentConfirmPassword;

    private AppCompatSpinner         appCompatSpinnerStoreBank;

    private AppCompatButton          appCompatButtonRegisterAgent;
    private AppCompatTextView        appCompatTextViewLoginLinkAgent;

    private InputValidation          inputValidation;
    private DatabaseHelperLoginAgent databaseHelperLoginAgent;
    private MCE_Agent                mceAgent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3_activity_spaza_reg);
        getSupportActionBar().hide();

        initViews();
        initListeners();
        initObjects();

    }

    /**
     * This method is to initialize views
     */
    private void initViews() {
        nestedScrollView                       = (NestedScrollView) findViewById(R.id.nestedScrollView);

        textInputLayoutAgentFirstName          = (TextInputLayout) findViewById(R.id.textInputLayoutAgentFirstName);
        textInputLayoutAgentLastName           = (TextInputLayout) findViewById(R.id.textInputLayoutAgentLastName);
        textInputLayoutAgentPhoneNumber        = (TextInputLayout) findViewById(R.id.textInputLayoutAgentPhoneNumber);
        textInputLayoutAgentStoreName          = (TextInputLayout) findViewById(R.id.textInputLayoutAgentStoreName);
        textInputLayoutAgentStoreAddress       = (TextInputLayout) findViewById(R.id.textInputLayoutAgentStoreAddress);
        textInputLayoutAgentStoreRegNumber     = (TextInputLayout) findViewById(R.id.textInputLayoutAgentStoreRegNumber);
        textInputLayoutAgentStoreAccNumber     = (TextInputLayout) findViewById(R.id.textInputLayoutAgentStoreAccountNumber);
        textInputLayoutAgentStoreBank          = (TextInputLayout) findViewById(R.id.textInputLayoutAgentStoreBank);
        textInputLayoutAgentEmail              = (TextInputLayout) findViewById(R.id.textInputLayoutAgentEmail);
        textInputLayoutAgentPassword           = (TextInputLayout) findViewById(R.id.textInputLayoutAgentPassword);
        textInputLayoutAgentConfirmPassword    = (TextInputLayout) findViewById(R.id.textInputLayoutAgentConfirmPassword);

        textInputEditTextAgentFirstName        = (TextInputEditText) findViewById(R.id.textInputEditTextAgentFirstName);
        textInputEditTextAgentLastName         = (TextInputEditText) findViewById(R.id.textInputEditTextAgentLastName);
        textInputEditTextAgentPhoneNumber      = (TextInputEditText) findViewById(R.id.textInputEditTextAgentPhoneNumber);
        textInputEditTextAgentStoreName        = (TextInputEditText) findViewById(R.id.textInputEditTextAgentStoreName);
        textInputEditTextAgentStoreAddress     = (TextInputEditText) findViewById(R.id.textInputEditTextAgentStoreAddress);
        textInputEditTextAgentStoreRegNumber   = (TextInputEditText) findViewById(R.id.textInputEditTextAgentStoreRegNumber);
        textInputEditTextAgentStoreAccNumber   = (TextInputEditText) findViewById(R.id.textInputEditTextAgentStoreAccountNumber);
        appCompatSpinnerStoreBank              = (AppCompatSpinner) findViewById(R.id.appCompatSpinnerStoreBank);
        textInputEditTextAgentEmail            = (TextInputEditText) findViewById(R.id.textInputEditTextAgentEmail);
        textInputEditTextAgentPassword         = (TextInputEditText) findViewById(R.id.textInputEditTextAgentPassword);
        textInputEditTextAgentConfirmPassword  = (TextInputEditText) findViewById(R.id.textInputEditTextAgentConfirmPassword);

        appCompatButtonRegisterAgent           = (AppCompatButton) findViewById(R.id.appCompatButtonRegisterAgent);

        appCompatTextViewLoginLinkAgent        = (AppCompatTextView) findViewById(R.id.appCompatTextViewLoginLinkAgent);
    }

    /**
     * This method is to initialize listeners
     */
    private void initListeners() {
        appCompatButtonRegisterAgent.setOnClickListener(this);
        appCompatTextViewLoginLinkAgent.setOnClickListener(this);
    }

    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {
        inputValidation            = new InputValidation(activity);
        databaseHelperLoginAgent   = new DatabaseHelperLoginAgent(activity);
        mceAgent                   = new MCE_Agent();
    }

    /**
     * This implemented method is to listen the click on view
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.appCompatButtonRegisterAgent:
                postDataToSQLite();
                break;

            case R.id.appCompatTextViewLoginLinkAgent:
                finish();
                break;
        }
    }

    /**
     * This method is to validate the input text fields and post data to SQLite
     */
    private void postDataToSQLite() {
        if (!inputValidation.isInputEditTextFilled(textInputEditTextAgentFirstName, textInputLayoutAgentFirstName, getString(R.string.error_message_first_name))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextAgentLastName, textInputLayoutAgentLastName, getString(R.string.error_message_last_name))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextAgentPhoneNumber, textInputLayoutAgentPhoneNumber, getString(R.string.error_message_phone_number))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextAgentStoreName, textInputLayoutAgentStoreName, getString(R.string.error_message_phone_number))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextAgentStoreAddress, textInputLayoutAgentStoreAddress, getString(R.string.error_message_phone_number))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextAgentStoreAccNumber, textInputLayoutAgentStoreAccNumber, getString(R.string.error_message_phone_number))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextAgentStoreRegNumber, textInputLayoutAgentStoreRegNumber, getString(R.string.error_message_phone_number))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextAgentEmail, textInputLayoutAgentEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextEmail(textInputEditTextAgentEmail, textInputLayoutAgentEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextAgentPassword, textInputLayoutAgentPassword, getString(R.string.error_message_password))) {
            return;
        }
        if (!inputValidation.isInputEditTextMatches(textInputEditTextAgentPassword, textInputEditTextAgentConfirmPassword,
                textInputLayoutAgentConfirmPassword, getString(R.string.error_password_match))) {
            return;
        }

        if (!databaseHelperLoginAgent.checkAgent(textInputEditTextAgentEmail.getText().toString().trim())) {

            mceAgent.setFirstName(textInputEditTextAgentFirstName.getText().toString().trim());
            mceAgent.setLastName(textInputEditTextAgentLastName.getText().toString().trim());
            mceAgent.setPhoneNumber(textInputEditTextAgentPhoneNumber.getText().toString().trim());
            mceAgent.setStoreName(textInputEditTextAgentStoreName.getText().toString().trim());
            mceAgent.setStoreAddress(textInputEditTextAgentStoreAddress.getText().toString().trim());
            mceAgent.setStoreAccNumber(textInputEditTextAgentStoreAccNumber.getText().toString().trim());
            mceAgent.setStoreRegNumber(textInputEditTextAgentStoreRegNumber.getText().toString().trim());
            mceAgent.setStoreBank(appCompatSpinnerStoreBank.getSelectedItem().toString().trim());
            mceAgent.setEmail(textInputEditTextAgentEmail.getText().toString().trim());
            mceAgent.setPassword(textInputEditTextAgentPassword.getText().toString().trim());

            databaseHelperLoginAgent.addUser(mceAgent);

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
        textInputEditTextAgentFirstName.setText(null);
        textInputEditTextAgentLastName.setText(null);
        textInputEditTextAgentPhoneNumber.setText(null);
        textInputEditTextAgentStoreName.setText(null);
        textInputEditTextAgentStoreAddress.setText(null);
        textInputEditTextAgentStoreAccNumber.setText(null);
        textInputEditTextAgentStoreRegNumber.setText(null);
        appCompatSpinnerStoreBank.setSelection(0);
        textInputEditTextAgentEmail.setText(null);
        textInputEditTextAgentPassword.setText(null);
        textInputEditTextAgentConfirmPassword.setText(null);
    }
}