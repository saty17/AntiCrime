package com.example.anticrime;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class base extends AppCompatActivity implements TabLayout.OnTabSelectedListener {


    private TabLayout tabLayout;
    private ViewPager2 viewPager2;

    private Toolbar toolbar;
    // Make sure to use the FloatingActionButton
    // for all the FABs
    FloatingActionButton mAddFab, mAddLoginFab, mAddRegisterFab;

    // These are taken to make visible and invisible along
    // with FABs
    TextView addLoginActionText, addRegisterActionText;

    // to check whether sub FAB buttons are visible or not.
    Boolean isAllFabsVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);


        tabLayout = findViewById(R.id.tablayout);
        viewPager2 = findViewById(R.id.viewpager);
        FragmentManager fragmentManager =  getSupportFragmentManager();
        VPAdapter adapter = new VPAdapter(fragmentManager,getLifecycle());
        viewPager2.setAdapter(adapter);

        tabLayout.addTab(tabLayout.newTab().setText("Crime"));
        tabLayout.addTab(tabLayout.newTab().setText("Missing"));
        tabLayout.addTab(tabLayout.newTab().setText("Complaint"));

        tabLayout.addOnTabSelectedListener(this);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

        toolbar=findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);
        // Register all the FABs with their IDs
        // This FAB button is the Parent
        mAddFab = findViewById(R.id.add_fab);
        // FAB button
        mAddLoginFab = findViewById(R.id.add_login_fab);
        mAddRegisterFab = findViewById(R.id.add_register_fab);

        // Also register the action name text, of all the FABs.
        addLoginActionText = findViewById(R.id.add_login_action_text);
        addRegisterActionText = findViewById(R.id.add_register_action_text);

        // Now set all the FABs and all the action name
        // texts as GONE
        mAddLoginFab.setVisibility(View.GONE);
        mAddRegisterFab.setVisibility(View.GONE);
        addLoginActionText.setVisibility(View.GONE);
        addRegisterActionText.setVisibility(View.GONE);

        // make the boolean variable as false, as all the
        // action name texts and all the sub FABs are invisible
        isAllFabsVisible = false;

        // We will make all the FABs and action name texts
        // visible only when Parent FAB button is clicked So
        // we have to handle the Parent FAB button first, by
        // using setOnClickListener you can see below
        mAddFab.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!isAllFabsVisible) {

                            // when isAllFabsVisible becomes
                            // true make all the action name
                            // texts and FABs VISIBLE.
                            mAddLoginFab.show();
                            mAddRegisterFab.show();
                            addLoginActionText.setVisibility(View.VISIBLE);
                            addRegisterActionText.setVisibility(View.VISIBLE);

                            // make the boolean variable true as
                            // we have set the sub FABs
                            // visibility to GONE
                            isAllFabsVisible = true;
                        } else {

                            // when isAllFabsVisible becomes
                            // true make all the action name
                            // texts and FABs GONE.
                            mAddLoginFab.hide();
                            mAddRegisterFab.hide();
                            addLoginActionText.setVisibility(View.GONE);
                            addRegisterActionText.setVisibility(View.GONE);

                            // make the boolean variable false
                            // as we have set the sub FABs
                            // visibility to GONE
                            isAllFabsVisible = false;
                        }
                    }
                });

        // below is the sample action to handle add person
        // FAB. Here it shows simple Toast msg. The Toast
        // will be shown only when they are visible and only
        // when user clicks on them
        mAddRegisterFab.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(base.this, register.class));
                    }
                });

        // below is the sample action to handle add alarm
        // FAB. Here it shows simple Toast msg The Toast
        // will be shown only when they are visible and only
        // when user clicks on them
        mAddLoginFab.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(base.this, login.class));
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.basemenuitem,menu);

        MenuItem.OnActionExpandListener onActionExpandListener = new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem menuItem) {
                Toast.makeText(base.this, "Search is Expanded", Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                Toast.makeText(base.this, "Search is Expanded", Toast.LENGTH_SHORT).show();
                return false;
            }
        };
        menu.findItem(R.id.action_search).setOnActionExpandListener(onActionExpandListener);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setQueryHint("Search Data Here..." );
        return true;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager2.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}