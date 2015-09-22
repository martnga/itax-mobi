package com.nganga.itaxmobi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by nganga on 9/17/15.
 */
public class ResidentialDetails extends Activity  implements AdapterView.OnItemSelectedListener{

    protected Spinner mCounty;
    protected EditText mStreet;
    protected EditText mTownCity;
    protected EditText mBuilding;
    protected EditText mDistrict;




    Button next;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.residential_details);


        mStreet = (EditText)findViewById(R.id.streetText);
        mTownCity = (EditText)findViewById(R.id.townCityText);
        mBuilding = (EditText)findViewById(R.id.buildingText);
        mCounty = (Spinner)findViewById(R.id.countySpinner);
        mDistrict = (EditText)findViewById(R.id.districtText);



        String Street = mStreet.getText().toString().trim();
        String Town = mTownCity.getText().toString().trim();
        String Building = mBuilding.getText().toString().trim();
        String County = mCounty.getSelectedItem().toString().trim();
        String District = mDistrict.getText().toString().trim();




        next = (Button) findViewById(R.id.regTwoNextBtn);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), TaxDetails.class);
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


