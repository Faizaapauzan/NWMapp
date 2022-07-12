package com.example.nwmapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.google.android.material.navigation.NavigationView;

public class PendingActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.tool_bar);

        setSupportActionBar(toolbar);

        navigationView.bringToFront();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.menu_drawer_open, R.string.menu_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()== R.id.home) {
            Intent intent5 = new Intent(PendingActivity.this,HomeActivity.class);
            startActivity(intent5);
        }

        if(item.getItemId()== R.id.assign) {
            Intent intent5 = new Intent(PendingActivity.this, AssignedJobActivity.class);
            startActivity(intent5);
        }

        if(item.getItemId()== R.id.unassign) {
            Intent intent5 = new Intent(PendingActivity.this, UnassignedJobActivity.class);
            startActivity(intent5);
        }

        if(item.getItemId()== R.id.complete) {
            Intent intent5 = new Intent(PendingActivity.this, CompleteActivity.class);
            startActivity(intent5);
        }

        if(item.getItemId()== R.id.incomplete) {
            Intent intent5 = new Intent(PendingActivity.this, IncompleteActivity.class);
            startActivity(intent5);
        }

        if(item.getItemId()== R.id.pending) {
            Intent intent5 = new Intent(PendingActivity.this, PendingActivity.class);
            startActivity(intent5);
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


}

