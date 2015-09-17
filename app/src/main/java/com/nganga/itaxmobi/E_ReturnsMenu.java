package com.nganga.itaxmobi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

/**
 * Created by nganga on 9/14/15.
 */
public class E_ReturnsMenu extends Activity{

    CardView returns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.e_returns_menu);

        returns = (CardView) findViewById(R.id.returns_card);

       returns.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View view) {
               Intent i = new Intent(getApplicationContext(), Returns.class);
               startActivity(i);
           }
       });


    }
}
