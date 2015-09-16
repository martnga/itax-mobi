package com.nganga.itaxmobi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

/**
 * Created by nganga on 9/14/15.
 */
public class E_RegistrationMenu extends Activity {

    CardView e_amendment_card;
    CardView e_cancelation_card;
    CardView e_dormance_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.e_registration_menu);

        e_amendment_card = (CardView) findViewById(R.id.e_amendment_card);
        e_cancelation_card = (CardView) findViewById(R.id.e_cancelation_card);
        e_dormance_card = (CardView) findViewById(R.id.e_dormance_card);

//

        e_amendment_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Amendment.class);
                startActivity(i);
            }
        });

        e_cancelation_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Cancelation.class);
                startActivity(i);
            }
        });

        e_dormance_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Dormance.class);
                startActivity(i);
            }
        });
    }
}


