package com.nganga.itaxmobi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

public class PersonalInfo extends Activity implements AdapterView.OnItemSelectedListener{

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


        mIdNumber = (EditText) findViewById(R.id.idNumberText);
        mBirthDate = (EditText) findViewById(R.id.birthDateText);
        mTaxRegion = (EditText) findViewById(R.id.taxRegionText);
        mPostalCode = (EditText)findViewById(R.id.postalCodeText);
        mPostalTown = (EditText)findViewById(R.id.postalAddressTownText);
        mEmployeeProfession = (Spinner)findViewById(R.id.employeeSpinner);
        mEmail = (EditText)findViewById(R.id.emailText);
        mPhoneNumber = (EditText)findViewById(R.id.phoneNumberText);



        String IdNumber = mIdNumber.getText().toString().trim();
        String BirthDate = mBirthDate.getText().toString().trim();
        String TaxArea = mTaxRegion.getText().toString().trim();
        String PostalCode = mPostalCode.getText().toString().trim();
        String PostalTown = mPostalTown.getText().toString().trim();
        String Employee = mEmployeeProfession.getSelectedItem().toString().trim();
        String Email = mEmail.getText().toString().trim();
        String PhoneNumber = mPhoneNumber.getText().toString().trim();



            next= (Button) findViewById(R.id.regOneNextBtn);
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(), ResidentialDetails.class);
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