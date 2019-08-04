package com.ldm.a0804tabbasic;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.ldm.a0804tabbasic.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {
    static Context mContext;
    public static Context getMainContext(){
        return mContext;
    }

    private int[] tabIcons = {
            R.drawable.ic_home_black_24dp,
            R.drawable.ic_settings_black_24dp,
            R.drawable.ic_cloud_black_24dp,
            R.drawable.ic_notifications_black_24dp
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        for(int i = 0;i<4;i++) {
            tabs.getTabAt(i).setIcon(tabIcons[i]);
        }

        FloatingActionButton fab = findViewById(R.id.fab);
        mContext = getApplicationContext();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}