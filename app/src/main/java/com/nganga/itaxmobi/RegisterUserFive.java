package com.nganga.itaxmobi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

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
    protected Spinner mCounty;
    protected EditText mDistrict;
    protected EditText mPhoneNumber;
    protected EditText mEmployeesPin;
    protected RadioButton mPaye;
    protected RadioButton mIncomeTax;
    protected Button mRegisterUser;
    protected Spinner mEmployeeProfession;
    Button registerUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_user5);

        // Initialised the above.
        mIdNumber = (EditText) findViewById(R.id.id_number);
        mBirthDate = (EditText) findViewById(R.id.birth1);
        mTaxArea = (EditText) findViewById(R.id.localityText);
        mPostalCode = (EditText)findViewById(R.id.postCode);
        mPostalTown = (EditText)findViewById(R.id.postal_address_town);
        mEmail = (EditText)findViewById(R.id.email);
        mStreet = (EditText)findViewById(R.id.street);
        mTown = (EditText)findViewById(R.id.town_city);
        mBuilding = (EditText)findViewById(R.id.building);
        mCounty = (Spinner)findViewById(R.id.county);
        mEmployeeProfession = (Spinner)findViewById(R.id.employee_spinner);
        mDistrict = (EditText)findViewById(R.id.district);
        mPhoneNumber = (EditText)findViewById(R.id.editText8);
        mEmployeesPin = (EditText)findViewById(R.id.employeesPin);
        mPaye = (RadioButton) findViewById(R.id.payeRadio);
        mIncomeTax = (RadioButton) findViewById(R.id.incomeTaxRadio);


        mRegisterUser = (Button) findViewById(R.id.registerUserBtn);
        mRegisterUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Home.class);
                startActivity(i);
            }
        });
/*
       //collect the user data and converts it to a string and removes extra spacing
               String IdNumber = mIdNumber.getText().toString().trim();
               String BirthDate = mBirthDate.getText().toString().trim();
                String TaxArea = mTaxArea.getText().toString().trim();
                String PostalCode = mPostalCode.getText().toString().trim();
                String PostalTown = mPostalTown.getText().toString().trim();
                String Email = mEmail.getText().toString().trim();
                String Street = mStreet.getText().toString().trim();
                String Town = mTown.getText().toString().trim();
                String Building = mBuilding.getText().toString().trim();
                String County = mCounty.getSelectedItem().toString().trim();
                String Employee = mEmployeeProfession.getSelectedItem().toString().trim();
                String District = mDistrict.getText().toString().trim();
                String PhoneNumber = mPhoneNumber.getText().toString().trim();
                String EmployeesPin = mEmployeesPin.getText().toString().trim();*/




    }
}
