package com.example.peken.duan1roject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.peken.duan1roject.Fragment.TabFragment;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
//    TextView header;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        header = findViewById(R.id.tv_acti_log_reg);
//        header.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//                startActivity(intent);
//            }
//        });
//        TextView tv_acti_log_reg = findViewById(R.id.tv_acti_log_reg);
//        tv_acti_log_reg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//                startActivity(intent);
//            }
//        });

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.nView);
        toolbar = findViewById(R.id.toolbar);

        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.containerView,new TabFragment()).commit();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.navi_home) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView,new TabFragment()).commit();
                }

                return false;
            }
        });

        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout, toolbar,R.string.app_name,
                R.string.app_name);
        drawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

    }

}
