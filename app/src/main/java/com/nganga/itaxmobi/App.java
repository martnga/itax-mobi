package com.nganga.itaxmobi;

import android.app.Application;
import android.content.Intent;

import com.parse.Parse;
import com.parse.ParseUser;

/**
 * Created by mansa on 10/1/15.
 */
public class App extends Application {

   /*ParseUser currentUser = ParseUser.getCurrentUser();
    if (currentUser != null) {
        // do stuff with the user
        Intent i = new Intent(getApplicationContext(), Home.class);
        startActivity(i);
    } else {
        //show the signup or login screen
        setContentView(R.layout.user_authenticate);

    } */


    @Override public void onCreate() {
        super.onCreate();

        Parse.initialize(this, getResources().getString(R.string.appId), getResources().getString(R.string.clientKey));

    }


}
