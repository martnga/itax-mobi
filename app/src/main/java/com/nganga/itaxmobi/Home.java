package com.nganga.itaxmobi;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

/**
 * Created by nganga on 9/11/15.
 */
public class Home extends Activity {

    CardView e_returns_card;
    CardView e_registration_card;
    CardView e_payments_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

       e_returns_card = (CardView) findViewById(R.id.e_returns_card);
       e_payments_card = (CardView) findViewById(R.id.e_returns_card);
       e_registration_card = (CardView) findViewById(R.id.e_registration_card);

//        setting background color

        e_returns_card.setCardBackgroundColor(Color.RED);
        e_registration_card.setCardBackgroundColor(Color.RED);
        e_payments_card.setCardBackgroundColor(Color.RED);

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
}
