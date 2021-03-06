package com.nganga.itaxmobi.Registration4Tax;

import android.app.FragmentTransaction;
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

import com.nganga.itaxmobi.DatePicker.DateDialog;
import com.nganga.itaxmobi.R;


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




            next= (Button) findViewById(R.id.regOneNextBtn);
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                  extractInfo();

                }
            });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void onStart(){

        super.onStart();
        mBirthDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {


            @Override
            public void onFocusChange(View view, boolean b) {


                if (hasWindowFocus()) {
                    DateDialog dialog = new DateDialog(view);
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    dialog.show(ft, "Datepicker");

                }
            }
        });


    }


    public void extractInfo(){

        final String idNumber = mIdNumber.getText().toString().trim();
        final String birthDate = mBirthDate.getText().toString().trim();
        final String taxArea = mTaxRegion.getText().toString().trim();
        final String postalCode = mPostalCode.getText().toString().trim();
        final String postalTown = mPostalTown.getText().toString().trim();
        final String employee = mEmployeeProfession.getSelectedItem().toString().trim();
        final String email = mEmail.getText().toString().trim();
        final String phoneNumber = mPhoneNumber.getText().toString().trim();

        if( !idNumber.isEmpty() && !birthDate.isEmpty() && !taxArea.isEmpty() &&
                !postalCode.isEmpty() && !postalTown.isEmpty() && !employee.isEmpty() &&
                !email.isEmpty() && !phoneNumber.isEmpty() ){

            Intent i = new Intent(getApplicationContext(), ResidentialDetails.class);
            i.putExtra("idNumber", idNumber);
            i.putExtra("birthDate", birthDate);
            i.putExtra("taxArea", taxArea);
            i.putExtra("postalCode", postalCode);
            i.putExtra("postalTown", postalTown);
            i.putExtra("employee", employee);
            i.putExtra("email", email);
            i.putExtra("phoneNumber", phoneNumber);
            startActivity(i);

        }else{

            Context context = getApplicationContext();
            CharSequence text = "Please Fill in The All Fields To Proceed.";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}