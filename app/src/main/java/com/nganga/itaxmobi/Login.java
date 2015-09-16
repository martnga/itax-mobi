package com.nganga.itaxmobi;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseObject;

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



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pinText.getText().toString().equals("admin") && passwordText.getText().toString().equals("admin")) {

                    ParseObject testObject = new ParseObject("TestObject");
                    testObject.put("foo", "bar");
                    testObject.saveInBackground();

                    Intent i = new Intent(getApplicationContext(), Home.class);
                    startActivity(i);

                }
                else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials. Try Again",Toast.LENGTH_SHORT).show();
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
