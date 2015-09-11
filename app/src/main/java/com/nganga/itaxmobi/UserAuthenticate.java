package com.nganga.itaxmobi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

/**
 * Created by nganga on 9/9/15.
 */
public class UserAuthenticate extends Activity {

    private CardView loginCard;
    private CardView registerCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_authenticate);

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
                Intent i = new Intent(getApplicationContext(), RegisterUser.class);
                startActivity(i);
            }
        });


    };
}
