package com.example.onlineclothingshopping;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Initializing the variable of view pager*/
        viewPager=findViewById(R.id.view_pager);

        /*Initializing the variable of tab layout*/
        tabLayout=findViewById(R.id.tab_layout);


        /*Object of AdapterForViewPager class*/
        AdapterForViewPager adapterForViewPager= new AdapterForViewPager(getSupportFragmentManager());

        adapterForViewPager.addFragments(new LoginActivity(), "Login");
        adapterForViewPager.addFragments(new RegisterationActivity(), "Sign Up");

        viewPager.setAdapter(adapterForViewPager);
        tabLayout.setupWithViewPager(viewPager);
    }
}
