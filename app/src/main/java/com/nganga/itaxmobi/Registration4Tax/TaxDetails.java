package com.nganga.itaxmobi.Registration4Tax;

import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import com.nganga.itaxmobi.UserMainMenu.Home;
import com.nganga.itaxmobi.R;
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




        mRegisterUser = (Button) findViewById(R.id.registerUserBtn);
        mRegisterUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              cacheData();
            }
        });

    }

    public void onStart(){

        super.onStart();
        mRegistrationDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {


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

    public void cacheData(){

        final Bundle bundle = getIntent().getExtras();
        final String employeesPin = mEmployeesPin.getText().toString().trim();
        final String registrationPassword = mRegisterPassword.getText().toString().trim();
        final String registrationDate = mRegistrationDate.getText().toString().trim();
        final String taxType = mTaxType.getSelectedItem().toString().trim();

        if( !employeesPin.isEmpty() && !registrationDate.isEmpty() && !taxType.isEmpty() && !registrationPassword.isEmpty()){


            final ProgressDialog progressDialog = new ProgressDialog(TaxDetails.this,
                    R.style.AppTheme_Dark_Dialog);
            progressDialog.setIndeterminate(true);
            progressDialog.setMessage("Please Wait A Moment ...");
            progressDialog.show();


            ParseUser user = new ParseUser();
            user.setUsername(employeesPin);
            user.setPassword(registrationPassword);
            user.setEmail(bundle.getString("email"));

            // other fields can be set just like with ParseObject
            user.put("idNumber",bundle.getString("idNumber"));
            user.put("birthDate", bundle.getString("birthDate"));
            user.put("phone", bundle.getString("phoneNumber"));
            user.put("registrationDate", registrationDate);
            user.put("taxType", taxType);
            user.put("taxArea", bundle.getString("taxArea"));
            user.put("postalCode", bundle.getString("postalCode"));
            user.put("postalTown", bundle.getString("postalTown"));
            user.put("employeeProfession", bundle.getString("employee"));
            user.put("street", bundle.getString("street"));
            user.put("town", bundle.getString("town"));
            user.put("building", bundle.getString("building"));
            user.put("county", bundle.getString("county"));
            user.put("district", bundle.getString("district"));

            user.signUpInBackground(new SignUpCallback() {
                public void done(ParseException e) {
                    if (e == null) {

                        Intent i = new Intent(getApplicationContext(), Home.class);
                        startActivity(i);

                    } else {
                        // Sign up didn't succeed. Look at the ParseException
                        // to figure out what went wrong

                        // This show a pop up message to the user with info about the error
                        AlertDialog.Builder builder = new AlertDialog.Builder(TaxDetails.this);
                        builder.setMessage(e.getMessage());
                        builder.setTitle("Sorry Mate!");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //to close the dialog
                                dialogInterface.dismiss();
                            }
                        });

                        AlertDialog  dialog = builder.create();
                        dialog.show();

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
}
