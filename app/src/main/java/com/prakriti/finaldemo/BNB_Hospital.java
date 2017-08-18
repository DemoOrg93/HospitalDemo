package com.prakriti.finaldemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;



public class BNB_Hospital extends AppCompatActivity {
    private ListView mainListView ;
    private ArrayAdapter<String> listAdapter ;
    TextView contact, description;
    ListView faciliteslist;
    TextView textView, txtcopy;
    ExpandableListView exv;
    WebView webView;
    ImageView imgcopy, imgvg_grup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bnb__hospital);
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);


        final ProgressDialog pd = ProgressDialog.show(BNB_Hospital.this, "", "Please wait,Page is Loading...", true);
        pd.show();

        WebView view = new WebView(this);
        //  view.setVerticalScrollBarEnabled(false);

        ((WebView)findViewById(R.id.vg)).addView(view);

        WebSettings mWebSettings = view.getSettings();
        view.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        view.setScrollbarFadingEnabled(false);
        view.loadData(getString(R.string.cdescription), "text/html; charset=utf-8", "utf-8");
        pd.dismiss();



        imgvg_grup = (ImageView) findViewById(R.id.vg_grup);
        contact = (TextView) findViewById(R.id.txtContact);
      //  description = (TextView) findViewById(R.id.txtdescription);
       // faciliteslist = (ListView) findViewById(R.id.hospitalfacilities);


        exv=(ExpandableListView)findViewById(R.id.hospitalfacilities);
        exv.setAdapter(new Facilitiesadapter(this));




        exv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {



            @Override
            public boolean onChildClick(ExpandableListView parent, android.view.View v, int groupPosition, int childPosition, long id) {
                switch (groupPosition) {
                    case 1:
                        switch (childPosition) {
                            case 0:
                                teaching();
                                Intent myIntent = new Intent(BNB_Hospital.this, Destination.class);
                                startActivity(myIntent);
                                finish();
                                break;
                            case 1: bnb();
                                Intent myIntent1 = new Intent(BNB_Hospital.this, Destination.class);
                                startActivity(myIntent1);
                                //do something
                                break;
                            case 2: bir();
                                Intent myIntent2 = new Intent(BNB_Hospital.this, Destination.class);
                                startActivity(myIntent2);
                                //do something
                                break;
                            case 3: patan();
                                Intent myIntent3 = new Intent(BNB_Hospital.this, Destination.class);
                                startActivity(myIntent3);
                                //do something
                                break;

                            case 14: vayodha();
                                Intent myIntent5 = new Intent(BNB_Hospital.this, Destination.class);
                                startActivity(myIntent5);
                                //do something
                                break;
                        }
                    case 2:
                        switch (childPosition)

                        {
                            case 0:
                                football();
                                Intent myIntent = new Intent(BNB_Hospital.this, Destination.class);
                                startActivity(myIntent);
                                break;
                            case 1:
                                //do something
                                break;
                        }
                }
                return false;
            }








            private void teaching() {
                Intent myIntent = new Intent(BNB_Hospital.this, Destination.class);
                startActivity(myIntent);}

            private void bnb() {
                Intent myIntent = new Intent(BNB_Hospital.this, Destination.class);
                startActivity(myIntent);}

            private void bir() {
                Intent myIntent = new Intent(BNB_Hospital.this, Destination.class);
                startActivity(myIntent);}

            private void patan() {
                Intent myIntent = new Intent(BNB_Hospital.this, Destination.class);
                startActivity(myIntent);

            }
            private void vayodha() {
                Intent myIntent = new Intent(BNB_Hospital.this, Destination.class);
                startActivity(myIntent);

            }

            private void football() {
                Intent myIntent = new Intent(BNB_Hospital.this, Destination.class);
                startActivity(myIntent);

            }   });


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }}






     /*   // Create and populate a List of planet names.
        String[] planets = new String[] { "Physician", "ENT", "Oodho", "Cardio",
                "General", "Uro", "Neuro", "Cardio"};
        ArrayList<String> planetList = new ArrayList<String>();
        planetList.addAll( Arrays.asList(planets) );

        // Create ArrayAdapter using the planet list.
        listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, planetList);

        // Add more planets. If you passed a String[] instead of a List<String>
        // into the ArrayAdapter constructor, you must not add more items.
        // Otherwise an exception will occur.
        listAdapter.add( "Therapy" );
        listAdapter.add( "Xray" );
        listAdapter.add( "Medicine" );

        // Set the ArrayAdapter as the ListView's adapter.
        faciliteslist.setAdapter( listAdapter );
    }
}

*/