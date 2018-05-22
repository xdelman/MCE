package com.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.model.MCE_Agent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xolani Man_X Delman on 2018-05-20.
 */
public class DatabaseHelperLoginAgent extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION             = 1;

    // Database Name
    private static final String DATABASE_NAME             = "MCEAgentManager.db";

    // User table name
    private static final String TABLE_USER                    = "mce_agent";

    // User Table Columns names
    private static final String COLUMN_AGENT_ID               = "user_id";
    private static final String COLUMN_AGENT_FIRST_NAME       = "first_name";
    private static final String COLUMN_AGENT_LAST_NAME        = "last_name";
    private static final String COLUMN_AGENT_PHONE_NUMBER     = "phone_number";
    private static final String COLUMN_AGENT_STORE_NAME       = "store_name";
    private static final String COLUMN_AGENT_STORE_ADDRESS    = "store_address";
    private static final String COLUMN_AGENT_STORE_REG_NUMBER = "store_reg_number";
    private static final String COLUMN_AGENT_STORE_ACC_NUMBER = "store_acc_number";
    private static final String COLUMN_AGENT_STORE_BANK       = "store_bank";
    private static final String COLUMN_AGENT_EMAIL            = "user_email";
    private static final String COLUMN_AGENT_PASSWORD         = "user_password";

    // create table sql query
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_AGENT_ID                 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_AGENT_FIRST_NAME         + " TEXT,"
            + COLUMN_AGENT_LAST_NAME          + " TEXT,"
            + COLUMN_AGENT_PHONE_NUMBER       + " TEXT,"
            + COLUMN_AGENT_STORE_NAME         + " TEXT,"
            + COLUMN_AGENT_STORE_ADDRESS      + " TEXT,"
            + COLUMN_AGENT_STORE_REG_NUMBER   + " TEXT,"
            + COLUMN_AGENT_STORE_ACC_NUMBER   + " TEXT,"
            + COLUMN_AGENT_STORE_BANK         + " TEXT,"
            + COLUMN_AGENT_EMAIL              + " TEXT,"
            + COLUMN_AGENT_PASSWORD           + " TEXT" + ")";

    // drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    /**
     * Constructor
     *
     * @param context
     */
    public DatabaseHelperLoginAgent(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Logs
        Log.w(DatabaseHelperLoginAgent.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        //Drop User Table if exist
        db.execSQL(DROP_USER_TABLE);

        // Create tables again
        onCreate(db);

    }

    /**
     * This method is to create user record
     *
     * @param mce_agent
     */
    public void addUser(MCE_Agent mce_agent) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_AGENT_FIRST_NAME, mce_agent.getFirstName());
        values.put(COLUMN_AGENT_LAST_NAME, mce_agent.getLastName());
        values.put(COLUMN_AGENT_PHONE_NUMBER, mce_agent.getPhoneNumber());
        values.put(COLUMN_AGENT_STORE_NAME, mce_agent.getStoreName());
        values.put(COLUMN_AGENT_STORE_ADDRESS, mce_agent.getStoreAddress());
        values.put(COLUMN_AGENT_STORE_REG_NUMBER, mce_agent.getStoreRegNumber());
        values.put(COLUMN_AGENT_STORE_ACC_NUMBER, mce_agent.getStoreAccNumber());
        values.put(COLUMN_AGENT_STORE_BANK, mce_agent.getStoreBank());
        values.put(COLUMN_AGENT_EMAIL, mce_agent.getEmail());
        values.put(COLUMN_AGENT_PASSWORD, mce_agent.getPassword());

        // Inserting Row
        db.insert(TABLE_USER, null, values);
        db.close();
    }

    /**
     * This method is to fetch all user and return the list of user records
     *
     * @return list
     */
    public List<MCE_Agent> getAllAgents() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_AGENT_ID,
                COLUMN_AGENT_EMAIL,
                COLUMN_AGENT_FIRST_NAME,
                COLUMN_AGENT_LAST_NAME,
                COLUMN_AGENT_PHONE_NUMBER,
                COLUMN_AGENT_STORE_NAME,
                COLUMN_AGENT_STORE_ADDRESS,
                COLUMN_AGENT_STORE_REG_NUMBER,
                COLUMN_AGENT_STORE_ACC_NUMBER,
                COLUMN_AGENT_STORE_BANK,
                COLUMN_AGENT_PASSWORD
        };
        // sorting orders
        String sortOrder =
                COLUMN_AGENT_FIRST_NAME + " ASC";
        List<MCE_Agent> mceAgentList = new ArrayList<MCE_Agent>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                MCE_Agent mce_agent = new MCE_Agent();
                mce_agent.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_AGENT_ID))));
                mce_agent.setFirstName(cursor.getString(cursor.getColumnIndex(COLUMN_AGENT_FIRST_NAME)));
                mce_agent.setLastName(cursor.getString(cursor.getColumnIndex(COLUMN_AGENT_LAST_NAME)));
                mce_agent.setPhoneNumber(cursor.getString(cursor.getColumnIndex(COLUMN_AGENT_PHONE_NUMBER)));
                mce_agent.setStoreName(cursor.getString(cursor.getColumnIndex(COLUMN_AGENT_STORE_NAME)));
                mce_agent.setStoreAddress(cursor.getString(cursor.getColumnIndex(COLUMN_AGENT_STORE_ADDRESS)));
                mce_agent.setStoreRegNumber(cursor.getString(cursor.getColumnIndex(COLUMN_AGENT_STORE_REG_NUMBER)));
                mce_agent.setStoreAccNumber(cursor.getString(cursor.getColumnIndex(COLUMN_AGENT_STORE_ACC_NUMBER)));
                mce_agent.setStoreBank(cursor.getString(cursor.getColumnIndex(COLUMN_AGENT_STORE_BANK)));
                mce_agent.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_AGENT_EMAIL)));
                mce_agent.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_AGENT_PASSWORD)));
                // Adding user record to list
                mceAgentList.add(mce_agent);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return mceAgent list
        return mceAgentList;
    }

    /**
     * This method to update user record
     *
     * @param mce_agent
     */
    public void updateAgent(MCE_Agent mce_agent) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_AGENT_FIRST_NAME, mce_agent.getFirstName());
        values.put(COLUMN_AGENT_LAST_NAME, mce_agent.getLastName());
        values.put(COLUMN_AGENT_PHONE_NUMBER, mce_agent.getPhoneNumber());
        values.put(COLUMN_AGENT_STORE_NAME, mce_agent.getStoreName());
        values.put(COLUMN_AGENT_STORE_ADDRESS, mce_agent.getStoreAddress());
        values.put(COLUMN_AGENT_STORE_REG_NUMBER, mce_agent.getStoreRegNumber());
        values.put(COLUMN_AGENT_STORE_ACC_NUMBER, mce_agent.getStoreAccNumber());
        values.put(COLUMN_AGENT_STORE_BANK, mce_agent.getStoreBank());
        values.put(COLUMN_AGENT_EMAIL, mce_agent.getEmail());
        values.put(COLUMN_AGENT_PASSWORD, mce_agent.getPassword());

        // updating row
        db.update(TABLE_USER, values, COLUMN_AGENT_ID + " = ?",
                new String[]{String.valueOf(mce_agent.getId())});
        db.close();
    }

    /**
     * This method is to delete user record
     *
     * @param mce_agent
     */
    public void deleteUser(MCE_Agent mce_agent) {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_USER, COLUMN_AGENT_ID + " = ?",
                new String[]{String.valueOf(mce_agent.getId())});
        db.close();
    }

    /**
     * This method to check user exist or not
     *
     * @param email
     * @return true/false
     */
    public boolean checkAgent(String email) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_AGENT_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = COLUMN_AGENT_EMAIL + " = ?";

        // selection argument
        String[] selectionArgs = {email};

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'xolani@mce.com';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

    /**
     * This method to check agent exist or not
     *
     * @param email
     * @param password
     * @return true/false
     */
    public boolean checkAgent(String email, String password) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_AGENT_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_AGENT_EMAIL + " = ?" + " AND " + COLUMN_AGENT_PASSWORD + " = ?";

        // selection arguments
        String[] selectionArgs = {email, password};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'xolani@mce.com' AND user_password = '1234';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }
}
