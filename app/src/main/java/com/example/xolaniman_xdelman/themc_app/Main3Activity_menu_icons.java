package com.example.xolaniman_xdelman.themc_app;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.model.SelectDialogTransactionCall;
import com.model.SelectDialogWalletCalls;


public class Main3Activity_menu_icons extends AppCompatActivity {

    private String m_Text="";
    public ImageButton butt1, butt2, butt3, butt4, butt5, butt6, butt7;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3_activity_menu_icons);
        SelectDialogListenerWalletButton();
        SelectDialogListenerTransactionsButton();
        //SelectDialogListenerNotificationsButton();
        SelectDialogListenerRewardsButton();
        //SelectDialogListenerAboutButton();
        SelectDialogListenerAccountButton();
        //SelectDialogListenerCommentsButton();

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

    public void SelectDialogListenerWalletButton(){
        butt1 = (ImageButton)findViewById(R.id.button_wallet);
        butt1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SelectDialogWalletButton();
                    }
                }
        );
    }

    public void SelectDialogListenerTransactionsButton(){
        butt1 = (ImageButton)findViewById(R.id.button_transactions);
        butt1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SelectDialogTransactionsButton();
                    }
                }
        );
    }

    /*public void SelectDialogListenerNotificationsButton(){
        butt1 = (ImageButton)findViewById(R.id.button_notifications);
        butt1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SelectDialogNotificationsButton();
                    }
                }
        );
    }*/

    public void SelectDialogListenerRewardsButton(){
        butt1 = (ImageButton)findViewById(R.id.button_rewards);
        butt1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SelectDialogRewardsButton();
                    }
                }
        );
    }

    /**
     * Removed methods since button calling them are also removed
     *
    public void SelectDialogListenerAboutButton(){
        butt1 = (ImageButton)findViewById(R.id.button_about);
        butt1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SelectDialogAboutButton();
                    }
                }
        );
    }*/

    public void SelectDialogListenerAccountButton(){
        butt1 = (ImageButton)findViewById(R.id.button_account);
        butt1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SelectDialogAccountButton();
                    }
                }
        );
    }

    /*public void SelectDialogListenerCommentsButton(){
        butt1 = (ImageButton)findViewById(R.id.button_comments);
        butt1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SelectDialogCommentsButton();
                    }
                }
        );
    }*/

    public void SelectDialogWalletButton(){
        ////////////////////Alert Dialog or Input Dialog code////////////////////
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Welcome **User_Name**, you are on MTN. Please Select your choice:");
        builder.setMessage(
                "1. My MCE Balances \n" +
                "0. Previous Selection");

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

                //Call a method if option 1 is selected
                SelectDialogWalletCalls dialogCalls = new SelectDialogWalletCalls();

                if(m_Text.equalsIgnoreCase("1")) {

                    dialog.dismiss();   //Dismisses the current screen to make way for the new one
                    System.out.println("**************%$%$############Xolani Delman My Guy************* " + m_Text + " is the text supplied");

                    Intent mntIntent = new Intent("com.model.SelectDialogWalletCalls");   //New screen that hold the requested dialog box
                    startActivity(mntIntent);
                    try {
                        dialogCalls.selectDialogWallet();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

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

    public void SelectDialogTransactionsButton(){
        ////////////////////Alert Dialog or Input Dialog code////////////////////
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Welcome **User_Name**, you are on MTN. Please Select your choice:");
        builder.setMessage("1. Transfer Airtime \n" +
                "2. Receiver/Recipient of MCE Airtime **??Explain**?? \n" +
                "3. MCE Airtime Balance \n");

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

                //Call a method if option 1 is selected
                //SelectDialogWalletCalls dialogCalls = new SelectDialogWalletCalls();
                SelectDialogTransactionCall dialogCalls = new SelectDialogTransactionCall();

                if(m_Text.equalsIgnoreCase("1")) {

                    dialog.dismiss();   //Dismisses the current screen to make way for the new one
                    System.out.println("**************%$%$############Xolani Delman My Guy************* " + m_Text + " is the text supplied");

                    Intent mntIntent = new Intent("com.model.SelectDialogTransactionCall");   //New screen that hold the requested dialog box
                    startActivity(mntIntent);
                    try {
                        dialogCalls.selectDialogFirstTransaction();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if(m_Text.equals("3")) {
                    dialog.dismiss();   //Dismisses the current screen to make way for the new one
                    System.out.println("**************%$%$############Xolani Delman My Guy************* " + m_Text + " is the text supplied");

                    SelectDialogWalletCalls dialogCalls2 = new SelectDialogWalletCalls();
                    Intent mntIntent = new Intent("com.model.SelectDialogWalletCalls");   //New screen that hold the requested dialog box
                    startActivity(mntIntent);
                    try {
                        dialogCalls2.selectDialogSecondTransaction();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else{
                        System.out.println("************Selection error************ "); //Cover selecting number out of scope
                    }
        }});
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();

    }

    public void SelectDialogNotificationsButton(){         //Notifications
        ////////////////////Alert Dialog or Input Dialog code////////////////////
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Welcome **User_Name**, you are on MTN. Please Select your choice:");
        builder.setMessage(
                "1. Notification page \n" +
                "0. Previous Selection");

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

    public void SelectDialogRewardsButton(){
        ////////////////////Alert Dialog or Input Dialog code////////////////////
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Welcome **User_Name**, you are on MTN. Please Select your choice:");
        builder.setMessage("Hello! You do not have rewards currently. \n" +
                "Transfer/Receive more that R20 today and get you reward :) \n" +
                "0. Previous Selection");

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

    public void SelectDialogAboutButton(){
        ////////////////////Alert Dialog or Input Dialog code////////////////////
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Welcome **User_Name**, you are on MTN. Please Select your choice:");
        builder.setMessage("Click here to read About the MCE Application versions \n" +
                "0. Previous Selection");

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

    public void SelectDialogAccountButton(){
        ////////////////////Alert Dialog or Input Dialog code////////////////////
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Welcome **User_Name**, you are on MTN. Please Select your choice:");
        builder.setMessage("1. Edit My MCE Profile \n" +
                "2. Change My MCE password \n" +
                "0. Previous Selection");

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

    public void SelectDialogCommentsButton(){
        ////////////////////Alert Dialog or Input Dialog code////////////////////
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Welcome **User_Name**, you are on MTN. Please Select your choice:");
        builder.setMessage("As the MCE team we really appreciate any comments \n" +
                "from the users of the MCE application.  \n" +
                "Please also note that sending a comment or suggestion is totally optional. \n" +
                "1. Add Comment/Suggestion" +
                "0. Previous Selection");

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
