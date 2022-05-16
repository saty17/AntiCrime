package com.example.anticrime;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.anticrime.databinding.ActivitySkiphomeBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class skiphome extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivitySkiphomeBinding binding;
    SharedPrefManager sharedPrefManager;
    TextView etname, etemail;
    View view;

    FloatingActionButton mFab, mAddMissingFab, mAddCrimeFab, mAddComplaintFab;

    TextView addMissingActionText, addCrimeActionText, addComplaintActionText;

    // to check whether sub FAB buttons are visible or not.
    Boolean isAllFabsVisible;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.nav_header_skiphome);

        etname = (TextView) findViewById(R.id.etName);
        etemail = (TextView) findViewById(R.id.etEmail);
//
//
        sharedPrefManager=new SharedPrefManager(getApplicationContext());
//
        etname.setText(SharedPrefManager.getUser().getUserName());
        etemail.setText(SharedPrefManager.getUser().getEmail());

        binding = ActivitySkiphomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        setSupportActionBar(binding.appBarSkiphome.toolbar);

        mAddMissingFab = findViewById(R.id.add_missing_fab);
        mAddCrimeFab = findViewById(R.id.add_crime_fab);
        mAddComplaintFab = findViewById(R.id.add_complaint_fab);

        // Also register the action name text, of all the FABs.
        addMissingActionText = findViewById(R.id.add_missing_action_text);
        addCrimeActionText = findViewById(R.id.add_crime_action_text);
        addComplaintActionText = findViewById(R.id.add_complaint_action_text);

        // Now set all the FABs and all the action name
        // texts as GONE
        mAddMissingFab.setVisibility(View.GONE);
        mAddCrimeFab.setVisibility(View.GONE);
        mAddComplaintFab.setVisibility(View.GONE);
        addMissingActionText.setVisibility(View.GONE);
        addCrimeActionText.setVisibility(View.GONE);
        addComplaintActionText.setVisibility(View.GONE);

        // make the boolean variable as false, as all the
        // action name texts and all the sub FABs are invisible
        isAllFabsVisible = false;
        binding.appBarSkiphome.fab.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                if (!isAllFabsVisible) {

                    // when isAllFabsVisible becomes
                    // true make all the action name
                    // texts and FABs VISIBLE.
                    mAddMissingFab.show();
                    mAddCrimeFab.show();
                    mAddComplaintFab.show();
                    addMissingActionText.setVisibility(View.VISIBLE);
                    addCrimeActionText.setVisibility(View.VISIBLE);
                    addComplaintActionText.setVisibility(View.VISIBLE);

                    // make the boolean variable true as
                    // we have set the sub FABs
                    // visibility to GONE
                    isAllFabsVisible = true;
                } else {

                    // when isAllFabsVisible becomes
                    // true make all the action name
                    // texts and FABs GONE.
                    mAddMissingFab.hide();
                    mAddCrimeFab.hide();
                    mAddComplaintFab.hide();
                    addMissingActionText.setVisibility(View.GONE);
                    addCrimeActionText.setVisibility(View.GONE);
                    addComplaintActionText.setVisibility(View.GONE);

                    // make the boolean variable false
                    // as we have set the sub FABs
                    // visibility to GONE
                    isAllFabsVisible = false;
                }
            }



        });
        mAddMissingFab.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(skiphome.this, MissingRegister.class));
                    }
                });
        mAddComplaintFab.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(skiphome.this, ComplaintRegister.class));
                    }
                });
        mAddCrimeFab.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(skiphome.this, CrimeRegister.class));
                    }
                });

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_profile_setting,R.id.nav_complaint_status,R.id.nav_crime_status,R.id.nav_missing_person_status,R.id.nav_crime_around_you,R.id.nav_missing,R.id.nav_Complaint)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_skiphome);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState){
//        View view=inflater.inflate(R.layout.nav_header_skiphome, container, false);
//        etname= view.findViewById(R.id.etname);
//        etemail= view.findViewById(R.id.etemail);
//
//        sharedPrefManager = new SharedPrefManager(getApplicationContext());
//
//        etname.setText(sharedPrefManager.getUser().getUserName());
//        etemail.setText(sharedPrefManager.getUser().getEmail());
//
//        return view;
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.skiphome, menu);
        //return true;
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.action_logout:
                logoutUser();
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    private void logoutUser() {

        sharedPrefManager.logout();
        Intent intent = new Intent(skiphome.this, index.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

        Toast.makeText(this, "You have been Logout", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_skiphome);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

}