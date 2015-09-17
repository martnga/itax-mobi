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
public class Returns extends Activity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    Button download;




    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.returns);

//        spinner = (Spinner) findViewById(R.id.type_of_returns_spinner);
//
////        created the adapter that will handle the spinner
//        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.type_of_returns_array, android.R.layout.simple_spinner_item);
//
//        spinner.setAdapter(adapter);
//        spinner.setOnItemSelectedListener(this);

        download= (Button) findViewById(R.id.downloadFormBtn);
       download.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i = new Intent(getApplicationContext(), P9Webview.class);
               startActivity(i);
           }
       });



    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        // the toast notification displays what was selected
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
