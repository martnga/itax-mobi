package com.nganga.itaxmobi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.parse.ParseUser;

/**
 * Created by mansa on 10/1/15.
 */
public class CurrentUser extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_user);

        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
            // do stuff with the user
            Intent i = new Intent(getApplicationContext(), Home.class);
            startActivity(i);
        } else {
            //show the signup or login screen

            Intent i = new Intent(getApplicationContext(), UserAuthenticate.class);
            startActivity(i);
        }

    }
}
