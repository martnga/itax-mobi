package com.nganga.itaxmobi;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by nganga on 9/11/15.
 */
public class Home extends Activity {

    // Array of strings storing registration menu details.
    String[] title = new String[]{
            "e-Ammendment",
            "e-Cancelation",
            "e-Dormance",
    };

    String[] returns_title = new String[]{
            "e-Returns",
            "Cosult returns",
    };

    // Array of integers points to images stored in /res/drawable/
    int[] menu_icons = new int[]{
            R.drawable.e_amendment,
            R.drawable.e_cancellation,
            R.drawable.e_dormance,

    };

    int[] returns_menu_icons = new int[]{
            R.drawable.e_return,
            R.drawable.consult_e_returns,
    };



    // Array of strings to store currencies
    String[] description = new String[]{
            "Edit Your Registration Details",
            "Cancel Tax Payment For given Party",
            "Account for missed Tax Returns",

    };

    String[] returns_description = new String[]{
            "File your Returns",
            "Consult on Returns issues",

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);


        // Each row in the list stores country name, currency and flag
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();
        List<HashMap<String,String>> bList = new ArrayList<HashMap<String,String>>();

        for(int i=0;i<3;i++){
            HashMap<String, String> e_registration_options = new HashMap<String,String>();
            e_registration_options.put("task", title[i]);
            e_registration_options.put("description", description[i]);
            e_registration_options.put("menu_icon", Integer.toString(menu_icons[i]));
            aList.add(e_registration_options);
        }

        for(int i=0;i<3;i++){
            HashMap<String, String> e_returns_options = new HashMap<String,String>();
            e_returns_options.put("returns_task", returns_title[i]);
            e_returns_options.put("returns_description", returns_description[i]);
            e_returns_options.put("returns_menu_icon", Integer.toString(returns_menu_icons[i]));
            bList.add(e_returns_options);
        }

        // Keys used in Hashmap
        String[] from = { "task","description","menu_icon" };
        String[] returns_from = { "returns_task","returns_description","returns_menu_icon" };

        // Ids of views in listview_layout
        int[] to = { R.id.title,R.id.task_description,R.id.list_image};

        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.list_row, from, to);
        SimpleAdapter returns_adapter = new SimpleAdapter(getBaseContext(), bList, R.layout.list_row, returns_from, to);

        // Getting a reference to listview of main.xml layout file
        ListView e_registration_list = (ListView) findViewById(R.id.e_registration_list);
        ListView e_returns_list = (ListView) findViewById(R.id.e_returns_list);

        // Setting the adapter to the listView
        e_registration_list.setAdapter(adapter);
        e_returns_list.setAdapter(returns_adapter);

    }
}
