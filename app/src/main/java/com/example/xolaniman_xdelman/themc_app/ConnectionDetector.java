package com.example.xolaniman_xdelman.themc_app;

import android.app.Service;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Xolani Man_X Delman on 2017-01-31.
 */
public class ConnectionDetector {

    Context myContext;
    public ConnectionDetector(Context context){
        this.myContext = context;
    }

    public boolean isConnected(){
        ConnectivityManager connectivity = (ConnectivityManager)myContext.getSystemService(Service.CONNECTIVITY_SERVICE);
        if(connectivity != null){
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if(info != null){
                return true;
            }
        }
        return false;
    }

}
