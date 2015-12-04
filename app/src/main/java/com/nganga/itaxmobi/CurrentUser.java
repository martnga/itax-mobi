package com.nganga.itaxmobi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nganga.itaxmobi.Registration4Tax.UserAuthenticate;
import com.nganga.itaxmobi.UserMainMenu.Home;
import com.parse.ParseUser;

/**
 * Created by mansa on 10/1/15.
 */
public class CurrentUser extends Activity {

    Button contiueBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_user);

        contiueBtn = (Button) findViewById(R.id.continueBtn);

        final ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
            // do stuff with the user
            Intent i = new Intent(getApplicationContext(), Home.class);
            startActivity(i);
        } else {
            //show the signup or login screen

            Intent i = new Intent(getApplicationContext(), UserAuthenticate.class);
            startActivity(i);
        }


        contiueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
        });

    }
}
