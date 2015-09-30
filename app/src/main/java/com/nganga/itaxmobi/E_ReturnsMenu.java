package com.nganga.itaxmobi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by nganga on 9/14/15.
 */
public class E_ReturnsMenu extends ActionBarActivity{

    CardView returns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.e_returns_menu);

        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_kra);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        returns = (CardView) findViewById(R.id.returns_card);

       returns.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View view) {
               Intent i = new Intent(getApplicationContext(), Returns.class);
               startActivity(i);
           }
       });


    }
}
