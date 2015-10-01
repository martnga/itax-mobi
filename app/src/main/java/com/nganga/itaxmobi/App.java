package com.nganga.itaxmobi;

import android.app.Application;
import android.content.Intent;

import com.parse.Parse;


/**
 * Created by mansa on 10/1/15.
 */
public class App extends Application {




    @Override public void onCreate() {
        super.onCreate();

        Parse.initialize(this, getResources().getString(R.string.appId), getResources().getString(R.string.clientKey));


    }


}
