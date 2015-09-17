package com.nganga.itaxmobi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by nganga on 9/17/15.
 */
public class RegisterUserFive extends Activity {

    protected EditText mIdNumber;
    protected EditText mBirthDate;
    protected EditText mTaxArea;
    protected EditText mPostalCode;
    protected EditText mPostalTown;
    protected EditText mEmail;
    protected EditText mStreet;
    protected EditText mTown;
    protected EditText mBuilding;
    protected EditText mCounty;
    protected EditText mDistrict;
    protected EditText mPhoneNumber;
    protected EditText mEmployeesPin;
    protected RadioButton mPaye;
    protected RadioButton mIncomeTax;
    protected Button mRegisterUser;
    Button registerUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_user5);

        // Initialised the above.
        mIdNumber = (EditText)findViewById(R.id.id_number);
        mBirthDate = (EditText)findViewById(R.id.birth1);
        mTaxArea = (EditText)findViewById(R.id.localityText);
        mPostalCode = (EditText)findViewById(R.id.postCode);
        mPostalTown = (EditText)findViewById(R.id.postal_address_town);
        mEmail = (EditText)findViewById(R.id.email);
        mStreet = (EditText)findViewById(R.id.street);
        mTown = (EditText)findViewById(R.id.town_city);
        mBuilding = (EditText)findViewById(R.id.building);
        mCounty = (EditText)findViewById(R.id.county);
        mDistrict = (EditText)findViewById(R.id.district);
        mPhoneNumber = (EditText)findViewById(R.id.editText8);
        mEmployeesPin = (EditText)findViewById(R.id.employeesPin);
        mPaye = (RadioButton) findViewById(R.id.payeRadio);
        mIncomeTax = (RadioButton) findViewById(R.id.incomeTaxRadio);
        mRegisterUser = (Button)findViewById(R.id.registerUserBtn);


       registerUser = (Button) findViewById(R.id.registerUserBtn);
        registerUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Home.class);
                startActivity(i);
            }
        });

//        listens to the register button
        mRegisterUser.setOnClickListener(new View.OnClickListener(){
            @Override
        public void onClick(View view){
                // There is a toast notification below

                Toast.makeText(RegisterUserFive.this, "Registered", Toast.LENGTH_LONG).show();
            }
        });
    }
}
