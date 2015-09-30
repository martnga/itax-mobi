package com.nganga.itaxmobi;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
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

/**
 * Created by nganga on 9/15/15.
 */
public class Returns extends ActionBarActivity  {

    Button mDownload;
    Button mSubmit;
    protected Spinner mReturnsType;
    EditText mReturnsDateFrom;
    EditText mReturnsDateTo;



    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.returns);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_kra);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


        Parse.initialize(this, String.valueOf(R.string.appId), String.valueOf(R.string.clientKey));

        mDownload = (Button) findViewById(R.id.downloadFormBtn);
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

                    Intent i = new Intent(getApplicationContext(), Home.class);
                    startActivity(i);


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
