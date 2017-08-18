package com.prakriti.finaldemo;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.support.v7.widget.SearchView;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity implements android.support.v7.widget.SearchView.OnQueryTextListener, android.support.v7.widget.SearchView.OnCloseListener {

    SearchView searchView;
    MyExpandableListAdapter accomodationAdapter;
    ExpandableListView expandableListView;
    // MyExpandableListAdapter adapter;

    SearchManager searchManager;

    ArrayList<ParentRow> originalList = new ArrayList<ParentRow>();
    ArrayList<ParentRow> showTheseParentList = new ArrayList<ParentRow>();
    MenuItem searchItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);


        displayList();



    }


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

                if (groupPosition == 1) {
                    switch (childPosition) {
                        case 0:
                            bir();
                            Intent myIntent2 = new Intent(Main3Activity.this, Description.class);
                            startActivity(myIntent2);
                            finish();
                            break;


                        case 1:
                            teaching();
                            Intent myIntent = new Intent(Main3Activity.this, Baseball.class);
                            startActivity(myIntent);
                            finish();
                            //do something
                            break;
                        case 2:
                            bnb();
                            Intent myIntent1 = new Intent(Main3Activity.this, BNB_Hospital.class);
                            startActivity(myIntent1);
                            finish();

                            break;
                        //do something

                        case 3: patan();
                            Intent myIntent3 = new Intent(Main3Activity.this,Patan_Hospital.class);
                            startActivity(myIntent3);
                            //do something
                            break;

                        case 14: vayodha();
                            Intent myIntent5 = new Intent(Main3Activity.this, Description.class);
                            startActivity(myIntent5);
                            //do something
                            break;


                    }}
                else if (groupPosition == 1) {
                    switch (childPosition) {
                        case 0:

                            teaching();
                            Intent myIntent = new Intent(Main3Activity.this, Description.class);
                            startActivity(myIntent);
                            finish();
                            break;
                        case 1:
                            bnb();
                            Intent myIntent1 = new Intent(Main3Activity.this, Description.class);
                            startActivity(myIntent1);
                            //do something
                            break;
                    }

                }

                return false;
            }


            private void bir() {
             //   Intent myIntent = new Intent(Main3Activity.this, Description.class);
              //  startActivity(myIntent);
                 }



            private void teaching() {
               // Intent myIntent = new Intent(Main3Activity.this,Baseball.class);
               // startActivity(myIntent);
                    }

            private void bnb() {
              //  Intent myIntent = new Intent(Main3Activity.this, BNB_Hospital.class);
              //  startActivity(myIntent);
                }

            private void patan() {
               // Intent myIntent = new Intent(Main3Activity.this, Patan_Hospital.class);
                //startActivity(myIntent);

            }
            private void vayodha() {
               // Intent myIntent = new Intent(Main3Activity.this, Description.class);
               // startActivity(myIntent);

            }

            private void football() {
               // Intent myIntent = new Intent(Main3Activity.this, Description.class);
              //  startActivity(myIntent);

            } });}








    private void loadData() {
        ArrayList<ChildRow> childRows = new ArrayList<ChildRow>();
        ParentRow parentRow = null;
        childRows.add(new ChildRow(R.mipmap.ic_launcher, "Prakriti Adhikari"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher, "Swikriti Adhikari"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher, "Sonika Maharjan"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher, "Ranjita Rawal"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher, "Sabina Niraula"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher, "Prakash Luitel"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher, "Sanjiv Ranjit"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher, "Niraj Gurung"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher, "Deepak Adhikari"));
        childRows.add(new ChildRow(R.mipmap.ic_launcher, "Udhav Adhikari"));
        parentRow = new ParentRow("Doctor List", childRows);
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
        parentRow = new ParentRow("Hospital", childRows);
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
        searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(this);
        searchView.setOnCloseListener(this);
        searchView.requestFocus();
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
      //  displayList();
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String newText) {
        accomodationAdapter.filterData(newText);
       // displayList();
        return false;
    }

}

