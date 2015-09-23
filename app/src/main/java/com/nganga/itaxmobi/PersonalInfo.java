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
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by nganga on 9/9/15.
 */

//      added the adapterview to allow the clicks on items to be registered

public class PersonalInfo extends ActionBarActivity implements AdapterView.OnItemSelectedListener{

    protected EditText mIdNumber;
    protected Spinner mEmployeeProfession;
    protected EditText mBirthDate;
    protected EditText mTaxRegion;
    protected EditText mPostalCode;
    protected EditText mPostalTown;
    protected EditText mEmail;
    protected EditText mPhoneNumber;
    private Button next;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);


        mIdNumber = (EditText) findViewById(R.id.idNumberText);
        mBirthDate = (EditText) findViewById(R.id.birthDateText);
        mTaxRegion = (EditText) findViewById(R.id.taxRegionText);
        mPostalCode = (EditText)findViewById(R.id.postalCodeText);
        mPostalTown = (EditText)findViewById(R.id.postalAddressTownText);
        mEmployeeProfession = (Spinner)findViewById(R.id.employeeSpinner);
        mEmail = (EditText)findViewById(R.id.emailText);
        mPhoneNumber = (EditText)findViewById(R.id.phoneNumberText);



        final String idNumber = mIdNumber.getText().toString().trim();
        final String birthDate = mBirthDate.getText().toString().trim();
        final String taxArea = mTaxRegion.getText().toString().trim();
        final String postalCode = mPostalCode.getText().toString().trim();
        final String postalTown = mPostalTown.getText().toString().trim();
        final String employee = mEmployeeProfession.getSelectedItem().toString().trim();
        final String email = mEmail.getText().toString().trim();
        final String phoneNumber = mPhoneNumber.getText().toString().trim();



            next= (Button) findViewById(R.id.regOneNextBtn);
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(idNumber != null && birthDate != null && taxArea != null &&
                                    postalCode != null && postalTown != null && employee != null &&
                                    email != null && phoneNumber != null){

                        Intent i = new Intent(getApplicationContext(), ResidentialDetails.class);
                        startActivity(i);

                    }else{

                        Context context = getApplicationContext();
                        CharSequence text = "Please Fill in The All Fields To Proceed.";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }

                }
            });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}