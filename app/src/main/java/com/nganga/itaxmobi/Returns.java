package com.nganga.itaxmobi;

import android.app.Activity;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.nganga.itaxmobi.DatePicker.DateDialog;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

/**
 * Created by nganga on 9/15/15.
 */
public class Returns extends ActionBarActivity  {

    TextView mDownload;
    Button mSubmit;
    protected Spinner mReturnsType;
    EditText mReturnsDateFrom;
    EditText mReturnsDateTo;



    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.returns);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);


        mDownload = (TextView) findViewById(R.id.downloadFormText);
        mSubmit = (Button) findViewById(R.id.submitReturnsBtn);
        mReturnsType = (Spinner)findViewById(R.id.type_of_returns_spinner);
        mReturnsDateFrom = (EditText) findViewById(R.id.return_period_from);
        mReturnsDateTo = (EditText) findViewById(R.id.return_period_to);




        mDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), P9Webview.class);
                startActivity(i);
            }
        });

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String returnsType = mReturnsType.getSelectedItem().toString().trim();
                final String  returnsDateFrom = mReturnsDateFrom.getText().toString().trim();
                final String returnsDateTo = mReturnsDateTo.getText().toString().trim();

                if( !returnsType.isEmpty() && !returnsDateFrom.isEmpty() && !returnsDateTo.isEmpty()){

                    final ProgressDialog progressDialog = new ProgressDialog(Returns.this,
                            R.style.AppTheme_Dark_Dialog);
                    progressDialog.setIndeterminate(true);
                    progressDialog.setMessage("Uploading ...");
                    progressDialog.show();

                    ParseObject returns = new ParseObject("Returns");
                    returns.put("returnsType", returnsType);
                    returns.put("returnsDateFrom", returnsDateFrom);
                    returns.put("returnsDateTo", returnsDateTo);
                    returns.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {

                            if (e == null) {

                                AlertDialog.Builder builder = new AlertDialog.Builder(Returns.this);
                                builder.setMessage(e.getMessage());
                                builder.setTitle("Sorry Mate!");
                                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        //to close the dialog
                                        Intent intent = new Intent(getApplicationContext(), Home.class);
                                        startActivity(intent);
                                        dialogInterface.dismiss();
                                    }
                                });

                                AlertDialog dialog = builder.create();
                                dialog.show();



                            } else {
                                // Sign up didn't succeed. Look at the ParseException
                                // to figure out what went wrong

                                // This show a pop up message to the user with info about the error
                                AlertDialog.Builder builder = new AlertDialog.Builder(Returns.this);
                                builder.setMessage(e.getMessage());
                                builder.setTitle("Sorry Mate!");
                                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        //to close the dialog
                                        dialogInterface.dismiss();
                                    }
                                });

                                AlertDialog dialog = builder.create();
                                dialog.show();

                            }
                        }
                    });



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

    public void onStart(){

        super.onStart();
        mReturnsDateFrom.setOnFocusChangeListener(new View.OnFocusChangeListener() {


            @Override
            public void onFocusChange(View view, boolean b) {


                if (hasWindowFocus()) {
                    DateDialog dialog = new DateDialog(view);
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    dialog.show(ft, "Datepicker");

                }
            }
        });

        mReturnsDateTo.setOnFocusChangeListener(new View.OnFocusChangeListener(){


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
