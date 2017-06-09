package com.spotasapdesign.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.spotasapdesign.R;
import com.spotasapdesign.adapter.CategoryPagerAdapter;
import com.spotasapdesign.adapter.SongPagerAdapter;
import com.spotasapdesign.model.SongContent;
import com.spotasapdesign.ui.fragment.SongListFragmentFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private int cd = 0;
    private ViewPager topSongViewPager;
    private TabLayout topTabLayout;

    private ViewPager songListViewPager;
    private TabLayout albumTabLayout;

    private int[] tabIcons = {
            R.drawable.video,
            R.drawable.image,
            R.drawable.milestone
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        topSongViewPager = (ViewPager) findViewById(R.id.viewPager);
        topTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        topTabLayout.setupWithViewPager(topSongViewPager, true);



        SongPagerAdapter pagerAdapter = new SongPagerAdapter(this, SongContent.ITEMS);
        topSongViewPager.setAdapter(pagerAdapter);

        songListViewPager = (ViewPager) findViewById(R.id.songListViewpager);
        albumTabLayout = (TabLayout) findViewById(R.id.tabs);

        CategoryPagerAdapter categoryPagerAdapter = new CategoryPagerAdapter(getSupportFragmentManager(), this);

        categoryPagerAdapter.addFragment(new SongListFragmentFragment());
        categoryPagerAdapter.addFragment(new SongListFragmentFragment());
        categoryPagerAdapter.addFragment(new SongListFragmentFragment());

        songListViewPager.setAdapter(categoryPagerAdapter);
        albumTabLayout.setupWithViewPager(songListViewPager, true);

        albumTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getText().toString().equals(getString(R.string.videos))) {
                    tab.setIcon(R.drawable.select_video);
                } else if(tab.getText().toString().equals(getString(R.string.images))) {
                    tab.setIcon(R.drawable.select_image);
                } else {
                    tab.setIcon(R.drawable.select_milestone);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if(tab.getText().toString().equals(getString(R.string.videos))) {
                    tab.setIcon(R.drawable.video);
                } else if(tab.getText().toString().equals(getString(R.string.images))) {
                    tab.setIcon(R.drawable.image);
                } else {
                    tab.setIcon(R.drawable.milestone);
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        setUpTabs();
    }

    private void setUpTabs() {
        albumTabLayout.getTabAt(0).setIcon(R.drawable.select_video);
        albumTabLayout.getTabAt(1).setIcon(tabIcons[1]);
        albumTabLayout.getTabAt(2).setIcon(tabIcons[2]);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
