package com.nganga.itaxmobi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by nganga on 9/15/15.
 */
public class Returns extends Activity  {

    Button download;
    protected Spinner mreturnsType;



    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.returns);



        download= (Button) findViewById(R.id.downloadFormBtn);
       download.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i = new Intent(getApplicationContext(), P9Webview.class);
               startActivity(i);
           }
       });

        mreturnsType = (Spinner)findViewById(R.id.type_of_returns_spinner);
        String returnsType = mreturnsType.getSelectedItem().toString().trim();



    }

}
