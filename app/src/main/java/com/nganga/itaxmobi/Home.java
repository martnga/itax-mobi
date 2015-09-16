package com.nganga.itaxmobi;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * Created by nganga on 9/11/15.
 */
public class Home extends ActionBarActivity {

    Toolbar toolbar;
    CardView e_returns_card;
    CardView e_registration_card;
    CardView e_payments_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        e_returns_card = (CardView) findViewById(R.id.e_returns_card);
       e_payments_card = (CardView) findViewById(R.id.e_returns_card);
       e_registration_card = (CardView) findViewById(R.id.e_registration_card);

//        setting background color

        e_returns_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), E_ReturnsMenu.class);
                startActivity(i);
            }
        });

        e_registration_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), E_RegistrationMenu.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.items, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        super.onOptionsItemSelected(item);

        switch(item.getItemId()){
            case R.id.passwordIcon:
                Toast.makeText(getBaseContext(), "TODO v2", Toast.LENGTH_SHORT).show();
                break;

            case R.id.profileIcon:
                Toast.makeText(getBaseContext(), "TODO v2", Toast.LENGTH_SHORT).show();
                break;

            case R.id.ledgerIcon:
                Toast.makeText(getBaseContext(), "TODO v2", Toast.LENGTH_SHORT).show();
                break;


        }
        return true;

    }
}
