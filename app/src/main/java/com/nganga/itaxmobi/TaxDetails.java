package com.nganga.itaxmobi;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.nganga.itaxmobi.DatePicker.DateDialog;

/**
 * Created by nganga on 9/17/15.
 */
public class TaxDetails extends Activity {

    protected EditText mEmployeesPin;
    protected Spinner  mTaxType;
    protected EditText mRegistrationDate;

    Button mRegisterUser;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tax_details);

        mEmployeesPin = (EditText)findViewById(R.id.employeesPinText);
        mRegistrationDate = (EditText)findViewById(R.id.registrationDateText);
        mTaxType = (Spinner)findViewById(R.id.taxTypeSpinner);


        String EmployeesPin = mEmployeesPin.getText().toString().trim();
        String RegistrationDate = mRegistrationDate.getText().toString().trim();
        String TaxType = mTaxType.getSelectedItem().toString().trim();

        mRegisterUser = (Button) findViewById(R.id.registerUserBtn);
        mRegisterUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Home.class);
                startActivity(i);
            }
        });

    }

    public void onStart(){

        super.onStart();
        mRegistrationDate.setOnFocusChangeListener(new View.OnFocusChangeListener(){


            @Override
            public void onFocusChange(View view, boolean b) {


                if(hasWindowFocus()){
                    DateDialog dialog=new DateDialog(view);
                    FragmentTransaction ft =getFragmentManager().beginTransaction();
                    dialog.show(ft,"Datepicker");

                }
            }
        });
    }
}
