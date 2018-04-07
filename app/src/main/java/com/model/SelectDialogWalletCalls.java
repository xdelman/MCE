package com.model;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;
import com.example.xolaniman_xdelman.themc_app.R;

public class SelectDialogWalletCalls extends AppCompatActivity {

    String m_Text = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_dialog_wallet_calls);
        try {
            selectDialogWallet();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called when a user selects option "1" from the wallet button
     */

    public void selectDialogWallet()throws Exception{
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Balance Check");
        builder.setMessage("Your Balance is: R150.20" +
                "0. Back");

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



    /**
     * This method is called when a user selects option "1" from the Transaction button
     */

    public void selectDialogSecondTransaction()throws Exception{
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Receiver/Recipient");
        builder.setMessage("This is a receiver/recipient popup...Khandicacisele Mhle?");

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

}