package com.nganga.itaxmobi.UserMainMenu;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import com.nganga.itaxmobi.R;

/**
 * Created by nganga on 9/17/15.
 */
public class E_PaymentsMenu  extends ActionBarActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.e_payments_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

    }
}
