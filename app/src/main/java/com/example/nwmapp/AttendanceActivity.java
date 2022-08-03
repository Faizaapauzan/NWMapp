package com.example.nwmapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.nwmapp.Storage.SharedPrefManager;
import com.google.android.material.navigation.NavigationView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AttendanceActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    Button btnSave;
    Button btnUpdate, btnIn, btnOut; // for dialog box
    TextView currentDate,clockIn, clockOut; // for dialog box
    AlertDialog dialog;
    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

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

        sharedPrefManager=new SharedPrefManager(getApplicationContext());


        // for attendance layout
        btnSave = findViewById(R.id.btnSave);


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //builder.setTitle("Attendance");

        View view =getLayoutInflater().inflate(R.layout.dialog_attendance,null);
        currentDate = view.findViewById(R.id.currentDate);
        btnUpdate = view.findViewById(R.id.btnUpdate); //dialog box button
        clockIn = view.findViewById(R.id.clockIn);
        clockOut = view.findViewById(R.id.clockOut);
        btnIn = view.findViewById(R.id.btnIn);
        btnOut = view.findViewById(R.id.btnOut);

        currentDate.setText(getCurrentDate());

        btnIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clockIn.setText(getInTime());

            }
        });

        btnOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clockOut.setText(getOutTime());
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        builder.setView(view);
        dialog = builder.create();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });


    }

    private String getCurrentDate(){
        return new SimpleDateFormat("dd-MM-yyyy",Locale.getDefault()).format(new Date());
    }

    private String getInTime(){
        return new SimpleDateFormat("hh:mm aa",Locale.getDefault()).format(new Date());
    }

    private String getOutTime(){
        return new SimpleDateFormat("hh:mm aa",Locale.getDefault()).format(new Date());
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
        Intent intent=new Intent(AttendanceActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

        Toast.makeText(this, "You have been logged out.", Toast.LENGTH_SHORT).show();

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()== R.id.home) {
            Intent intent = new Intent(AttendanceActivity.this, HomeActivity.class);
            startActivity(intent);
        }

        if(item.getItemId()== R.id.attendance) {
            Intent intent = new Intent(AttendanceActivity.this, AttendanceActivity.class);
            startActivity(intent);
        }

        if(item.getItemId()== R.id.resthour) {
            Intent intent = new Intent(AttendanceActivity.this, RestHourActivity.class);
            startActivity(intent);
        }

        if(item.getItemId()== R.id.assign) {
            Intent intent = new Intent(AttendanceActivity.this, AssignedJobActivity.class);
            startActivity(intent);
        }

        if(item.getItemId()== R.id.unassign) {
            Intent intent = new Intent(AttendanceActivity.this, UnassignedJobActivity.class);
            startActivity(intent);
        }

        if(item.getItemId()== R.id.complete) {
            Intent intent = new Intent(AttendanceActivity.this, CompleteActivity.class);
            startActivity(intent);
        }

        if(item.getItemId()== R.id.incomplete) {
            Intent intent5 = new Intent(AttendanceActivity.this, IncompleteActivity.class);
            startActivity(intent5);
        }

        if(item.getItemId()== R.id.pending) {
            Intent intent5 = new Intent(AttendanceActivity.this, PendingActivity.class);
            startActivity(intent5);
        }

        if(item.getItemId()== R.id.logout) {
            logout();
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}