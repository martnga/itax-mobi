package com.nganga.itaxmobi;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseUser;

/**
 * Created by nganga on 9/9/15.
 */
public class Login extends Activity{

    Button btnLogin,btnCancel;
    EditText pinText,passwordText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_user);

        btnLogin=(Button)findViewById(R.id.btnLogin);
        pinText=(EditText)findViewById(R.id.pinText);
        passwordText=(EditText)findViewById(R.id.passwordText);

        btnCancel=(Button)findViewById(R.id.btnCancel);
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "b8uq0Pb9IV1pInQGFLpg9sUFj0RqZK8mgwfFjHXk", "f6mEQtCQGOFB0TnUfYdRkkR7u66uGIPwP6Lr3UUJ");

//        listen to when the login button is clicked
        btnLogin.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            // get user input and convert it to string
                                            String pin = pinText.getText().toString().trim();
                                            String pass = passwordText.getText().toString().trim();
                                        }
                                    }
        ) ;
        ParseUser.logInInBackground("Jerry", "showmethemoney", new LogInCallback() {
            @Override
            public void done(ParseUser parseUser, com.parse.ParseException e) {

                if (e == null) {
                    // Hooray! The user is logged in.
                    Toast.makeText(Login.this, "Welcome back!", Toast.LENGTH_SHORT).show();

                    Intent takeUserHome = new Intent(Login.this, Home.class);
                    startActivity(takeUserHome);
                } else {
                    // Signup failed. Look at the ParseException to see what happened.
                    AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                   builder.setMessage(e.getMessage());
                    builder.setTitle("Sorry!");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int which) {
                            //close the dialog
                            dialogInterface.dismiss();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }

        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pinText.getText().toString().equals("admin") && passwordText.getText().toString().equals("admin")) {

                    ParseObject testObject = new ParseObject("TestObject");
                    testObject.put("foo", "bar");
                    testObject.saveInBackground();

                    Intent i = new Intent(getApplicationContext(), Home.class);
                    startActivity(i);

                } else {
                    Toast.makeText(getApplicationContext(), "Wrong Credentials. Try Again", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
