package com.nganga.itaxmobi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by nganga on 9/9/15.
 */

//      added the adapterview to allow the clicks on items to be registered

public class RegisterUser extends Activity implements AdapterView.OnItemSelectedListener{

    Button next;

//        declared the spinner below
    Spinner spinner;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_user1);
//          assigned the spinner
//        spinner = (Spinner) findViewById(R.id.employee_spinner);
//
////        created the adapter that will handle the spinner
//     ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.employee_array, android.R.layout.simple_spinner_item);
//
//        spinner.setAdapter(adapter);
//        spinner.setOnItemSelectedListener(this);


            next= (Button) findViewById(R.id.regOneNextBtn);
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(), RegisterUserTwo.class);
                    startActivity(i);
                }
            });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        // the toast notification displays what was selected
        TextView myText= (TextView) view;
        Toast.makeText(this,"You selected "+myText.getText(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}