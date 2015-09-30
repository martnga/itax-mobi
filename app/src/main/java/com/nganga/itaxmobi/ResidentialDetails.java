package com.nganga.itaxmobi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by nganga on 9/17/15.
 */
public class ResidentialDetails extends ActionBarActivity  implements AdapterView.OnItemSelectedListener{

    protected Spinner mCounty;
    protected EditText mStreet;
    protected EditText mTownCity;
    protected EditText mBuilding;
    protected EditText mDistrict;
    Button next;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.residential_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);


        mStreet = (EditText)findViewById(R.id.streetText);
        mTownCity = (EditText)findViewById(R.id.townCityText);
        mBuilding = (EditText)findViewById(R.id.buildingText);
        mCounty = (Spinner)findViewById(R.id.countySpinner);
        mDistrict = (EditText)findViewById(R.id.districtText);



        final String street = mStreet.getText().toString().trim();
        final String town = mTownCity.getText().toString().trim();
        final String building = mBuilding.getText().toString().trim();
        final String county = mCounty.getSelectedItem().toString().trim();
        final String district = mDistrict.getText().toString().trim();




        next = (Button) findViewById(R.id.regTwoNextBtn);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if( !street.isEmpty() && !town.isEmpty() && !building.isEmpty() &&
                        !district.isEmpty() && !county.isEmpty()){

                    Intent i = new Intent(getApplicationContext(), TaxDetails.class);
                    startActivity(i);

                }else{

                    Context context = getApplicationContext();
                    CharSequence text = "Please Fill in All The Fields To Proceed.";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
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


