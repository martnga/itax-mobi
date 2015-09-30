package com.nganga.itaxmobi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.parse.ParseUser;

/**
 * Created by nganga on 9/9/15.
 */
public class UserAuthenticate extends ActionBarActivity {

    private CardView loginCard;
    private CardView registerCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        setContentView(R.layout.user_authenticate);
        // This lets user skip to home if logged in
=======

        setContentView(R.layout.user_authenticate);
>>>>>>> a6397e9ff232abade5f438c8d5d1a9578078c574


        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_kra);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        loginCard = (CardView) findViewById(R.id.login_card);
        loginCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Login.class);
                startActivity(i);
            }
        });

        registerCard = (CardView) findViewById(R.id.register_card);
        registerCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), PersonalInfo.class);
                startActivity(i);
            }
        });


    };
}
