package com.nganga.itaxmobi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by nganga on 9/17/15.
 */
public class RegisterUserFour extends Activity {

    Button next;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_user4);

        next = (Button) findViewById(R.id.regFourNextBtn);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), RegisterUserFive.class);
                startActivity(i);
            }
        });

    }
}
