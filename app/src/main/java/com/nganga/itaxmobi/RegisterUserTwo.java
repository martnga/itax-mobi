package com.nganga.itaxmobi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by nganga on 9/17/15.
 */
public class RegisterUserTwo extends Activity  implements AdapterView.OnItemSelectedListener{

    Button next;
    Spinner spinner;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_user2);

        //assigned the spinner
//        spinner = (Spinner) findViewById(R.id.county);
//
//        //        created the adapter that will handle the spinner
//        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.county, android.R.layout.simple_spinner_item);
//
//        spinner.setAdapter(adapter);
//        spinner.setOnItemSelectedListener(this);


        next = (Button) findViewById(R.id.regTwoNextBtn);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), RegisterUserThree.class);
                startActivity(i);
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}


