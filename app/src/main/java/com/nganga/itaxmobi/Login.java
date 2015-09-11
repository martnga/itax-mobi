package com.nganga.itaxmobi;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by nganga on 9/9/15.
 */
public class Login extends Activity{

    Button btnLogin,btnCancel;
    EditText pinText,passwordText;

    TextView remainingAttemptsText;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_user);

        btnLogin=(Button)findViewById(R.id.btnLogin);
        pinText=(EditText)findViewById(R.id.pinText);
        passwordText=(EditText)findViewById(R.id.passwordText);

        btnCancel=(Button)findViewById(R.id.btnCancel);
        remainingAttemptsText =(TextView)findViewById(R.id.remainingAttempts_text);
        remainingAttemptsText.setVisibility(View.GONE);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pinText.getText().toString().equals("admin") &&

                        passwordText.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();

                    remainingAttemptsText.setVisibility(View.VISIBLE);
                    remainingAttemptsText.setBackgroundColor(Color.DKGRAY);
                    counter--;
                    remainingAttemptsText.setText(Integer.toString(counter));

                    if (counter == 0) {
                        btnLogin.setEnabled(false);
                    }
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
