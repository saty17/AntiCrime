package com.example.anticrime;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;

public class AdminPage extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);

        tabLayout = findViewById(R.id.tablayout);
        viewPager2 = findViewById(R.id.viewpager);
        FragmentManager fragmentManager =  getSupportFragmentManager();
        //VPAdapter adapter = new VPAdapter(fragmentManager,getLifecycle());
        //viewPager2.setAdapter(adapter);

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
        //setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.basemenuitem,menu);

        MenuItem.OnActionExpandListener onActionExpandListener = new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem menuItem) {
                Toast.makeText(AdminPage.this, "Search is Expanded", Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                Toast.makeText(AdminPage.this, "Search is Expanded", Toast.LENGTH_SHORT).show();
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