package com.nganga.itaxmobi.UserMainMenu;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.github.clans.fab.FloatingActionButton;
import com.nganga.itaxmobi.R;
import com.nganga.itaxmobi.Registration4Tax.UserAuthenticate;
import com.parse.ParseUser;


/**
 * Created by nganga on 9/11/15.
 */
public class Home extends ActionBarActivity {

    CardView e_returns_card;
    CardView e_registration_card;
    CardView e_payments_card;
    FloatingActionButton mLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        e_returns_card = (CardView) findViewById(R.id.e_returns_card);
       e_payments_card = (CardView) findViewById(R.id.e_payments_card);
       e_registration_card = (CardView) findViewById(R.id.e_registration_card);
        mLogout = (FloatingActionButton) findViewById(R.id.logoutBtn);

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

        e_payments_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), E_PaymentsMenu.class);
                startActivity(i);
            }
        });

        mLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(Home.this);
                builder.setMessage("Please Confirm That You Want To Logout");
                builder.setTitle("Logout");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                        final ProgressDialog progressDialog = new ProgressDialog(Home.this,
                                R.style.AppTheme_Dark_Dialog);
                        progressDialog.setIndeterminate(true);
                        progressDialog.setMessage("Please Wait...");
                        progressDialog.show();
                        ParseUser.logOut();
                        Intent intent = new Intent(getApplicationContext(), UserAuthenticate.class);
                        startActivity(intent);
                        dialogInterface.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        super.onOptionsItemSelected(item);
        return true;

    }
}

