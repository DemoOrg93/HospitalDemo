package com.prakriti.finaldemo;

import java.util.ArrayList;

import android.app.ActionBar;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.support.v4.view.MenuItemCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SearchView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.Toast;


public class Main2Activity extends Activity implements
        SearchView.OnQueryTextListener, SearchView.OnCloseListener {

    SearchView search;
    MyExpandableListAdapter accomodationAdapter;
    ExpandableListView expandableListView;
    // MyExpandableListAdapter adapter;

     SearchManager searchManager;

     ArrayList<ParentRow> originalList = new ArrayList<ParentRow>();
     ArrayList<ParentRow> showTheseParentList = new ArrayList<ParentRow>();
     MenuItem searchItem;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        search=(SearchView) findViewById(R.id.search_it);
        search.setQueryHint("Search");

        //*** setOnQueryTextFocusChangeListener ***
        search.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub

              //  Toast.makeText(getBaseContext(), String.valueOf(hasFocus),
                    //    Toast.LENGTH_SHORT).show();
            }
        });

        //*** setOnQueryTextListener ***
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                // TODO Auto-generated method stub
                accomodationAdapter.filterData(query);
                // displayList();
                return false;

            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // TODO Auto-generated method stub

                accomodationAdapter.filterData(newText);
                // displayList();
                return false;
            }
        });





       /* searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        search = (SearchView) findViewById(R.id.search_it);
        search.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        search.setIconifiedByDefault(false);
        search.setOnQueryTextListener(this);
        search.setOnCloseListener(this);*/

        //display the list
        displayList();
        //expand all Groups


    }


    //method to expand all groups



    //method to expand all groups
    private void displayList() {

        //display the list
        loadData();

        //get reference to the ExpandableListView
        expandableListView = (ExpandableListView) findViewById(R.id.accomodation_exp);
        //create the adapter by passing your ArrayList data
       accomodationAdapter = new MyExpandableListAdapter(getApplicationContext(),originalList);
        //attach the adapter to the list
        expandableListView.setAdapter(accomodationAdapter);


        setListener();

    }


    void setListener() {
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView listview, View view,
                                        int groupPosition, int childPosition, long id) {

                if (groupPosition == 0) {
                    switch (childPosition) {
                        case 0:
                            bir();
                            Intent myIntent2 = new Intent(Main2Activity.this, Description.class);
                            startActivity(myIntent2);
                           // finish();
                            break;


                        case 1:
                            teaching();
                            Intent myIntent = new Intent(Main2Activity.this, Baseball.class);
                            startActivity(myIntent);
                          //  finish();
                            //do something
                            break;
                        case 2:
                            bnb();
                            Intent myIntent1 = new Intent(Main2Activity.this, BNB_Hospital.class);
                            startActivity(myIntent1);
                           // finish();

                            break;
                            //do something

                        case 3: patan();
                            Intent myIntent3 = new Intent(Main2Activity.this,Patan_Hospital.class);
                            startActivity(myIntent3);
                          //  finish();
                            //do something
                            break;

                        case 14: vayodha();
                            Intent myIntent5 = new Intent(Main2Activity.this, Description.class);
                            startActivity(myIntent5);
                          //  finish();
                            //do something
                            break;


                    }}
                else if (groupPosition == 1) {
                    switch (childPosition) {
                        case 0:

                            teaching();
                            Intent myIntent = new Intent(Main2Activity.this, Description.class);
                            startActivity(myIntent);
                           // finish();
                            break;
                        case 1:
                            bnb();
                            Intent myIntent1 = new Intent(Main2Activity.this, Description.class);
                            startActivity(myIntent1);
                         //   finish();
                            //do something
                            break;
                    }

                }

                return false;
            }


            private void bir() {
               // Intent myIntent = new Intent(Main2Activity.this, Description.class);
               // startActivity(myIntent);
           // finish();
            }



            private void teaching() {
               // Intent myIntent = new Intent(Main2Activity.this,Baseball.class);
               // startActivity(myIntent);
          //  finish();
                }

            private void bnb() {
               // Intent myIntent = new Intent(Main2Activity.this, BNB_Hospital.class);
               // startActivity(myIntent);
           // finish();
                    }

            private void patan() {
                //Intent myIntent = new Intent(Main2Activity.this, Patan_Hospital.class);
                //startActivity(myIntent);
              //  finish();

            }
            private void vayodha() {
               // Intent myIntent = new Intent(Main2Activity.this, Description.class);
               // startActivity(myIntent);
              //  finish();

            }

            private void football() {
              //  Intent myIntent = new Intent(Main2Activity.this, Description.class);
               // startActivity(myIntent);
               // finish();

            } });}








    private void loadData() {
        ArrayList<ChildRow> childRows = new ArrayList<ChildRow>();
        ParentRow parentRow = null;
        childRows.add(new ChildRow(R.mipmap.ic_launcher, "Bir Hospital"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher, "Teaching Hospital"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher, "B & B Hospital"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher, "Patan Hospital"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher, "Vayodha Hospital"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher, "Kidney Center"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher, "KMC Hospital"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher, "ENT Hospital"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher, "Neuro Hospital"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher, "KMC Hospital"));
        parentRow = new ParentRow("Hospitals", childRows);
        originalList.add(parentRow);




        childRows = new ArrayList<ChildRow>();
        childRows.add(new ChildRow(R.mipmap.ic_launcher, "Bir Hospital"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher, "Teaching Hospital"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher, "B & B Hospital"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher, "Patan Hospital"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher, "Vayodha Hospital"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher, "Kidney Center"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher, "KMC Hospital"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher, "ENT Hospital"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher, "Neuro Hospital"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher, "KMC Hospital"));
        parentRow = new ParentRow("References", childRows);
        originalList.add(parentRow);
    }






   public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        searchItem = menu.findItem(R.id.action_search);
        search = (SearchView) MenuItemCompat.getActionView(searchItem);
        search.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        search.setIconifiedByDefault(false);
        search.setOnQueryTextListener(this);
        search.setOnCloseListener(this);
        search.requestFocus();
        return true;
    }



    @Override
    public boolean onClose() {
        accomodationAdapter.filterData("");
        // expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String query) {
        accomodationAdapter.filterData(query);
        //displayList();
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String newText) {
        accomodationAdapter.filterData(newText);
       // displayList();
        return false;
    }

}