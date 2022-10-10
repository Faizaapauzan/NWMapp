package com.example.nwmapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nwmapp.API.RetrofitClient;
import com.example.nwmapp.Storage.SharedPrefManager;
import com.example.nwmapp.adapter.IncompleteAdapter;
import com.example.nwmapp.models.JobAssign;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IncompleteActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    SharedPrefManager sharedPrefManager;

    RecyclerView incompleteRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incomplete);


        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.tool_bar);

        incompleteRV = findViewById(R.id.incompeleterv);
        incompleteRV.setLayoutManager(new LinearLayoutManager(this));

        incompleteData();

        setSupportActionBar(toolbar);

        navigationView.bringToFront();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.menu_drawer_open, R.string.menu_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        sharedPrefManager=new SharedPrefManager(getApplicationContext());

    }

    private void incompleteData() {
        Call<List<JobAssign>> callJob = RetrofitClient
                .getInstance()
                .getAPI()
                .getIncompleted();

        callJob.enqueue(new Callback<List<JobAssign>>() {
            @Override
            public void onResponse(Call<List<JobAssign>> call, Response<List<JobAssign>> response) {
                List<JobAssign> assignData = response.body();

                IncompleteAdapter adapter = new IncompleteAdapter(assignData);
                incompleteRV.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<JobAssign>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.toString(), Toast.LENGTH_LONG).show();

            }
        });
    }
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    private void logout() {

        sharedPrefManager.logout();
        Intent intent=new Intent(IncompleteActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

        Toast.makeText(this, "You have been logged out.", Toast.LENGTH_SHORT).show();

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()== R.id.home) {
            Intent intent5 = new Intent(IncompleteActivity.this,HomeActivity.class);
            startActivity(intent5);
        }

        if(item.getItemId()== R.id.attendance) {
            Intent intent = new Intent(IncompleteActivity.this, AttendanceActivity.class);
            startActivity(intent);
        }

        if(item.getItemId()== R.id.resthour) {
            Intent intent = new Intent(IncompleteActivity.this, RestHourActivity.class);
            startActivity(intent);
        }

        if(item.getItemId()== R.id.assign) {
            Intent intent5 = new Intent(IncompleteActivity.this, AssignedJobActivity.class);
            startActivity(intent5);
        }

        if(item.getItemId()== R.id.unassign) {
            Intent intent5 = new Intent(IncompleteActivity.this, UnassignedJobActivity.class);
            startActivity(intent5);
        }

        if(item.getItemId()== R.id.pending) {
            Intent intent5 = new Intent(IncompleteActivity.this, PendingActivity.class);
            startActivity(intent5);
        }

        if(item.getItemId()== R.id.complete) {
            Intent intent5 = new Intent(IncompleteActivity.this, CompleteActivity.class);
            startActivity(intent5);
        }

        if(item.getItemId()== R.id.incomplete) {
            Intent intent5 = new Intent(IncompleteActivity.this, IncompleteActivity.class);
            startActivity(intent5);
        }

        if(item.getItemId()== R.id.logout) {
            logout();
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


}