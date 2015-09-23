package com.nganga.itaxmobi;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.nganga.itaxmobi.DatePicker.DateDialog;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

/**
 * Created by nganga on 9/17/15.
 */
public class TaxDetails extends ActionBarActivity {

    protected EditText mEmployeesPin;
    protected Spinner  mTaxType;
    protected EditText mRegistrationDate;
    protected EditText mIdNumber;
    protected Spinner mEmployeeProfession;
    protected EditText mBirthDate;
    protected EditText mTaxRegion;
    protected EditText mPostalCode;
    protected EditText mPostalTown;
    protected EditText mEmail;
    protected EditText mPhoneNumber;
    protected Spinner mCounty;
    protected EditText mStreet;
    protected EditText mTownCity;
    protected EditText mBuilding;
    protected EditText mDistrict;
    protected  EditText mRegisterPassword;

    Button mRegisterUser;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tax_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        mEmployeesPin = (EditText)findViewById(R.id.employeesPinText);
        mRegisterPassword = (EditText)findViewById(R.id.registerPasswordText);
        mRegistrationDate = (EditText)findViewById(R.id.registrationDateText);
        mTaxType = (Spinner)findViewById(R.id.taxTypeSpinner);
        mIdNumber = (EditText) findViewById(R.id.idNumberText);
        mBirthDate = (EditText) findViewById(R.id.birthDateText);
        mTaxRegion = (EditText) findViewById(R.id.taxRegionText);
        mPostalCode = (EditText)findViewById(R.id.postalCodeText);
        mPostalTown = (EditText)findViewById(R.id.postalAddressTownText);
        mEmployeeProfession = (Spinner)findViewById(R.id.employeeSpinner);
        mEmail = (EditText)findViewById(R.id.emailText);
        mPhoneNumber = (EditText)findViewById(R.id.phoneNumberText);
        mStreet = (EditText)findViewById(R.id.streetText);
        mTownCity = (EditText)findViewById(R.id.townCityText);
        mBuilding = (EditText)findViewById(R.id.buildingText);
        mCounty = (Spinner)findViewById(R.id.countySpinner);
        mDistrict = (EditText)findViewById(R.id.districtText);


        final String employeesPin = mEmployeesPin.getText().toString().trim();
        final String registrationPassword = mRegisterPassword.getText().toString().trim();
        final String email = mEmail.getText().toString().trim();
        final String registrationDate = mRegistrationDate.getText().toString().trim();
        final String taxType = mTaxType.getSelectedItem().toString().trim();
        final String idNumber = mIdNumber.getText().toString().trim();
        final String birthDate = mBirthDate.getText().toString().trim();
        final String taxArea = mTaxRegion.getText().toString().trim();
        final String postalCode = mPostalCode.getText().toString().trim();
        final String postalTown = mPostalTown.getText().toString().trim();
        final String employeeProfession = mEmployeeProfession.getSelectedItem().toString().trim();
        final String phoneNumber = mPhoneNumber.getText().toString().trim();
        final String street = mStreet.getText().toString().trim();
        final String town = mTownCity.getText().toString().trim();
        final String building = mBuilding.getText().toString().trim();
        final String county = mCounty.getSelectedItem().toString().trim();
        final String district = mDistrict.getText().toString().trim();


        mRegisterUser = (Button) findViewById(R.id.registerUserBtn);
        mRegisterUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if( employeesPin != null && registrationDate != null && taxType != null && registrationPassword != null){

                    ParseUser user = new ParseUser();
                    user.setUsername(employeesPin);
                    user.setPassword(registrationPassword);
                    user.setEmail(email);

                    // other fields can be set just like with ParseObject
                    user.put("ID Number",idNumber);
                    user.put("birthDate", birthDate);
                    user.put("phone", phoneNumber);
                    user.put("registrationDate", registrationDate);
                    user.put("taxType", taxType);
                    user.put("taxArea", taxArea);
                    user.put("postalCode", postalCode);
                    user.put("postalTown", postalTown);
                    user.put("employeeProfession", employeeProfession);
                    user.put("street", street);
                    user.put("town", town);
                    user.put("building", building);
                    user.put("county", county);
                    user.put("district", district);

                    user.signUpInBackground(new SignUpCallback() {
                        public void done(ParseException e) {
                            if (e == null) {

                                Intent i = new Intent(getApplicationContext(), Home.class);
                                startActivity(i);

                            } else {
                                // Sign up didn't succeed. Look at the ParseException
                                // to figure out what went wrong

                                Context context = getApplicationContext();
                                CharSequence text = "Seems Like Something Went Wrong. Please Try Again.";
                                int duration = Toast.LENGTH_SHORT;

                                Toast toast = Toast.makeText(context, text, duration);
                                toast.show();
                            }
                        }
                    });



                }else{

                    Context context = getApplicationContext();
                    CharSequence text = "Please Fill In All The Fields To Proceed.";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
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
