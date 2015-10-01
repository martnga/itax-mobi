package com.nganga.itaxmobi;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

/**
 * Created by nganga on 9/9/15.
 */
public class UserAuthenticate extends ActionBarActivity {

    private CardView loginCard;
    private TextView registerLinkText;
    Button btnLogin;
    EditText mLoginPinText,mLoginPasswordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_authenticate);

        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);



        btnLogin=(Button)findViewById(R.id.btnLogin);
        mLoginPinText=(EditText)findViewById(R.id.loginPinText);
        mLoginPasswordText=(EditText)findViewById(R.id.loginPasswordText);






        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String loginPin = mLoginPinText.getText().toString().trim();
                final String loginPassword =  mLoginPasswordText.getText().toString().trim();

                if ( !loginPin.isEmpty() && !loginPassword.isEmpty()) {

                    final ProgressDialog progressDialog = new ProgressDialog(UserAuthenticate.this,
                            R.style.AppTheme_Dark_Dialog);
                    progressDialog.setIndeterminate(true);
                    progressDialog.setMessage("Authenticating ...");
                    progressDialog.show();

                    ParseUser.logInInBackground(loginPin, loginPassword, new LogInCallback() {
                        public void done(ParseUser user, ParseException e) {
                            if (user != null) {
                                // Hooray! The user is logged in.
                                Intent i = new Intent(getApplicationContext(), Home.class);
                                startActivity(i);
                            } else {
                                // Signup failed. Look at the ParseException to see what happened.
                                // This show a pop up message to the user with info about the error
                                AlertDialog.Builder builder = new AlertDialog.Builder(UserAuthenticate.this);
                                builder.setMessage(e.getMessage());
                                builder.setTitle("Sorry Mate!");
                                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        //to close the dialog
                                        dialogInterface.dismiss();
                                    }
                                });

                                AlertDialog  dialog = builder.create();
                                dialog.show();
                            }
                        }
                    });

                } else {
                    Toast.makeText(getApplicationContext(), "Please Fill In All The fields To Login", Toast.LENGTH_SHORT).show();
                }
            }
        });


        registerLinkText = (TextView) findViewById(R.id.registerLinkText);
        registerLinkText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), PersonalInfo.class);
                startActivity(i);
            }
        });


    };
}
