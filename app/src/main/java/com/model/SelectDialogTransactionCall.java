package com.model;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;

import com.example.xolaniman_xdelman.themc_app.Main3Activity_menu_icons;
import com.example.xolaniman_xdelman.themc_app.R;

public class SelectDialogTransactionCall extends AppCompatActivity {

    String m_Text = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_dialog_transaction_call);
        try {
            selectDialogFirstTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called when a user selects option "1" from the Transaction button
     */

    public void selectDialogFirstTransaction()throws Exception{
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Transfer Amount");
        builder.setMessage("Please provide the amount you want to transfer \n" +
                "0. Go Back");

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
                if(m_Text.equals("0")){
                    //Main3Activity_menu_icons backToTransactions = new Main3Activity_menu_icons();
                    Intent mntIntent = new Intent("com.model.SelectDialogTransactionCall");   //New screen that hold the requested dialog box
                    startActivity(mntIntent);
                    //backToTransactions.SelectDialogTransactionsButton();
                    //backToTransactions.SelectDialogListenerTransactionsButton();
                }
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
     * This method is called when a user selects option "2" from the Transaction button
     */

    public void selectDialogSecondTransaction()throws Exception{
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Transfer Amount");
        builder.setMessage("Please provide the amount you want to transfer");

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
