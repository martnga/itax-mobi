package com.nganga.itaxmobi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


/**
 * Created by nganga on 9/9/15.
 */

//      added the adapterview to allow the clicks on items to be registered

public class RegisterUser extends Activity implements AdapterView.OnItemSelectedListener{

    protected void onCreate(Bundle savedInstanceState) {
//        declared the spinner below
        Spinner spinner;

//          assigned the spinner
        spinner = (Spinner) findViewById(R.id.employee_spinner);

//        created the adapter that will handle the spinner
     ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.employee_array, android.R.layout.simple_spinner_item);

        spinner.setAdapter(adapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}