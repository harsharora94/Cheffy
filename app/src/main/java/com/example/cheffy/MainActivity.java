package com.example.cheffy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;

    String TAG = "placeautocomplete";
    TextView txtView;
    RatingBar ratingbar;
    Button button;


    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    ActionBarDrawerToggle actionBarDrawerToggle;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButtonClick();
        txtView = findViewById(R.id.txtView);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);


        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                drawerLayout.closeDrawers();

                //Remove Preference Fragment
                PrefFragment prefFragment = (PrefFragment) getFragmentManager().findFragmentByTag("PrefFragmentTag");
                if (getFragmentManager().findFragmentByTag("PrefFragmentTag") != null) {
                    getFragmentManager().beginTransaction().remove(prefFragment).commit();
                }
                //Remove Preference Fragment End
                /*ActionBar actionBar = getSupportActionBar();
                actionBar.setDisplayHomeAsUpEnabled(true);*/


                switch (menuItem.getItemId()) {
                    case R.id.manage_devices:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.containerView, new ManageDevicesFragment(), "ManageDevicesFragmentTag");
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Manage Devices");
                        menuItem.setChecked(true);
                        break;
                    case R.id.dashboard:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.containerView, new TabFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Cheffy");
                        menuItem.setChecked(true);
                        break;
                    case R.id.account:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.containerView, new AccountFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("My Account");
                        menuItem.setChecked(true);
                        break;
                    case R.id.preferences:
                             /*fragmentTransaction = getSupportFragmentManager().beginTransaction();
                             fragmentTransaction.replace(R.id.containerView, new PreferencesFragment());
                             fragmentTransaction.commit();
                             //getSupportActionBar().setTitle("Preferences");*/
                        //menuItem.setChecked(true);*/

                        //Intent intent = new Intent(MainActivity.this, PreferencesActivity.class);
                        //startActivity(intent);


                        getFragmentManager().beginTransaction().replace(R.id.containerView, new PrefFragment(), "PrefFragmentTag").commit();
                        getSupportActionBar().setTitle("Preferences");
                        menuItem.setChecked(true);

                        break;

                    case R.id.help:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.containerView, new HelpFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Help");
                        menuItem.setChecked(true);
                        break;
                    case R.id.contact_us:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.containerView, new ContactUsFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Contact Us");
                        menuItem.setChecked(true);
                        break;
                }
                return true;
            }
        });

        // Initialize Places.
        //Places.initialize(getApplicationContext(), "AIzaSyBhDTGEm_7PsirS6EH11wzUTJOBEbrriqs");
        // Create a new Places client instance.
        //PlacesClient placesClient = Places.createClient(this);

        // Initialize the AutocompleteSupportFragment.
        /*AutocompleteSupportFragment autocompleteFragment = (AutocompleteSupportFragment)
                getSupportFragmentManager().findFragmentById(R.id.autocomplete_fragment);

        // Specify the types of place data to return.
        autocompleteFragment.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME));

        // Set up a PlaceSelectionListener to handle the response.
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.
                txtView.setText(place.getName() + "," + place.getId());
                Log.i(TAG, "Place: " + place.getName() + ", " + place.getId());
            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                Log.i(TAG, "An error occurred: " + status);
            }
        });*/

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds toggle_switch to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {
/*            case R.id.subscribe_id:
                if (item.getTitle().equals("Subscribe")) {
                    try {
                        Toast.makeText(getApplicationContext(), "Subscribed to Cheffy.", Toast.LENGTH_LONG).show();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    item.setTitle("Unsubscribe");
                    return true;
                } else if (item.getTitle().equals("Unsubscribe")) {
                    try {
                        Toast.makeText(getApplicationContext(), "Unsubscribed from Cheffy.", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    item.setTitle("Subscribe");
                    return true;
                }*/

            case R.id.action_settings:

                //getFragmentManager().beginTransaction().replace(android.R.id.content, new PrefFragment()).commit();
                /*Intent intent = new Intent(this, PreferencesActivity.class);
                startActivity(intent);*/

                Toast.makeText(getApplicationContext(), "Powered By Cheffy", Toast.LENGTH_LONG).show();
                return true;


            case R.id.notifications_id:
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.containerView, new HistoryFragment(), "HistoryFragmentTag");
                fragmentTransaction.commit();
                getSupportActionBar().setTitle("History");

                //

                //

                return true;

            default:
                return super.onOptionsItemSelected(item);


        }
    }


    //SystemClock.sleep(1000);

        /*ManageDevicesFragment manageDevicesFragment = (ManageDevicesFragment) getSupportFragmentManager().findFragmentByTag("ManageDevicesFragmentTag");
        manageDevicesFragment.updateDevice(dname);*/
        /*try
        {
            mqttAndroidClient.publish("LT/AddDevice", dname.getBytes(), 0, false); // (3)
        } catch (MqttPersistenceException e)
        {
            e.printStackTrace();
        } catch (MqttException e)
        {
            e.printStackTrace();
        }        //*/


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            //Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
            Log.e("On Config Change", "LANDSCAPE");
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            //Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
            Log.e("On Config Change", "PORTRAIT");
        }

    }

    //sign out method
    public void signOut() {
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    public void addListenerOnButtonClick() {
        ratingbar = (RatingBar) findViewById(R.id.ratingBar);
        button = (Button) findViewById(R.id.button);
        //Performing action on Button Click
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //Getting the rating and displaying it on the toast
                String rating = String.valueOf(ratingbar.getRating());
                Toast.makeText(getApplicationContext(), rating, Toast.LENGTH_LONG).show();
            }

        });
    }
}


