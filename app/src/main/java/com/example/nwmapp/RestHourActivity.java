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
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class RestHourActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    // for navigation drawer
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    //for hide/show layout
    TextInputLayout textInputLayout;
    AutoCompleteTextView autoCompleteTextView;


    //time & date
    TextView todayDate,restOut,restIn;
    Button inBtn,outBtn,btnSave;
    TextView asst1,asstIn,asst2,asstIn2,asst3,asstIn3,asst4,asstIn4;
    Button outTimeAsst1,inTimeAsst1,outTimeAsst2,inTimeAsst2,outTimeAsst3,inTimeAsst3,outTimeAsst4,inTimeAsst4,asst_update;

    LinearLayout btn_ass, layout_hide_show;  // button layout hide & show

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_hour);

        //for navigation drawer & toolbar
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.tool_bar);

        // for hide & show layout
        btn_ass = findViewById(R.id.btn_ass);
        layout_hide_show = findViewById(R.id.layout_hide_show);


        //time & date
        todayDate = findViewById(R.id.todayDate);
        restOut = findViewById(R.id.restOut);
        restIn = findViewById(R.id.restIn);
        inBtn = findViewById(R.id.inBtn);
        outBtn = findViewById(R.id.outBtn);
        btnSave = findViewById(R.id.btnSave);
        asst1 = findViewById(R.id.asst1);
        asstIn = findViewById(R.id.asstIn);
        asst2 = findViewById(R.id.asst2);
        asstIn2 = findViewById(R.id.asstIn2);
        asst3 = findViewById(R.id.asst3);
        asstIn3 = findViewById(R.id.asstIn3);
        asst4 = findViewById(R.id.asst4);
        asstIn4 = findViewById(R.id.asstIn4);
        outTimeAsst1 = findViewById(R.id.outTimeAsst1);
        inTimeAsst1 = findViewById(R.id.inTimeAsst1);
        outTimeAsst2 = findViewById(R.id.outTimeAsst2);
        inTimeAsst2 = findViewById(R.id.inTimeAsst2);
        outTimeAsst3 = findViewById(R.id.outTimeAsst3);
        inTimeAsst3 = findViewById(R.id.inTimeAsst3);
        outTimeAsst4 = findViewById(R.id.outTimeAsst4);
        inTimeAsst4 = findViewById(R.id.inTimeAsst4);
        asst_update = findViewById(R.id.asst_update);


        //get current date
        todayDate.setText(getTodayDate());

        //get assistant clock out time
        outBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restOut.setText(getOutTime());
            }
        });

        //get assistant clock in time
        inBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restIn.setText(getInTime());
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //save to database
            }
        });




        autoCompleteTextView = findViewById(R.id.drop_items);
        textInputLayout = findViewById(R.id.ass_list);

        //test for dropdown list
        String [] items = {"Item 1", "Item 2", "Item 3"," Item 4"};
        ArrayAdapter<String> itemAdapter = new ArrayAdapter<>(RestHourActivity.this,R.layout.item_list,items);
        autoCompleteTextView.setAdapter(itemAdapter);


        setSupportActionBar(toolbar);

        navigationView.bringToFront();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.menu_drawer_open, R.string.menu_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //hide or show extra assistant
        btn_ass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int visible = layout_hide_show.getVisibility();
                if (visible==View.VISIBLE){
                    layout_hide_show.setVisibility(View.GONE);
                } else {
                    layout_hide_show.setVisibility(View.VISIBLE);
                }
            }
        });


        //extra assistant 1 clock in & out
        outTimeAsst1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                asst1.setText(getOutTimeAsst1());
            }
        });

        inTimeAsst1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                asstIn.setText(getInTimeAsst1());
            }
        });


        //get assistant 2 clock in & out time
        outTimeAsst2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                asst2.setText(getOutTimeAsst2());
            }
        });

        inTimeAsst2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                asstIn2.setText(getInTimeAsst2());
            }
        });


        //get assistant 3 clock in & out time
        outTimeAsst3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                asst3.setText(getOutTimeAsst3());
            }
        });

        inTimeAsst3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                asstIn3.setText(getInTimeAsst3());
            }
        });


        //get assistant 4 clock in & out time
        outTimeAsst4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                asst4.setText(getOutTimeAsst4());
            }
        });

        inTimeAsst4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                asstIn4.setText(getInTimeAsst4());
            }
        });

        //update data to database
        asst_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //save to database
            }
        });
    }



    //get current date
    private String getTodayDate() {
        return new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
    }

    //get assistant out time
    private String getOutTime() {
        return new SimpleDateFormat("hh:mm aa",Locale.getDefault()).format(new Date());
    }

    //get assistant in time
    private String getInTime(){
        return new SimpleDateFormat("hh:mm aa",Locale.getDefault()).format(new Date());
    }

    //get assistant 1 out & in time
    private String getOutTimeAsst1(){
        return new SimpleDateFormat("hh:mm aa",Locale.getDefault()).format(new Date());
    }

    private String getInTimeAsst1(){
        return new SimpleDateFormat("hh:mm aa",Locale.getDefault()).format(new Date());
    }

    //get assistant 2 clock in & out time
    private String getOutTimeAsst2(){
        return new SimpleDateFormat("hh:mm aa",Locale.getDefault()).format(new Date());
    }

    private String getInTimeAsst2(){
        return new SimpleDateFormat("hh:mm aa",Locale.getDefault()).format(new Date());
    }

    //get assistant 3 clock in & out time
    private String getOutTimeAsst3(){
        return new SimpleDateFormat("hh:mm aa",Locale.getDefault()).format(new Date());
    }

    private String getInTimeAsst3(){
        return new SimpleDateFormat("hh:mm aa",Locale.getDefault()).format(new Date());
    }


    //get assistant 4 clock in & out time
    private String getOutTimeAsst4(){
        return new SimpleDateFormat("hh:mm aa",Locale.getDefault()).format(new Date());
    }

    private String getInTimeAsst4(){
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()== R.id.home) {
            Intent intent = new Intent(RestHourActivity.this, HomeActivity.class);
            startActivity(intent);
        }

        if(item.getItemId()== R.id.attendance) {
            Intent intent = new Intent(RestHourActivity.this, AttendanceActivity.class);
            startActivity(intent);
        }

        if(item.getItemId()== R.id.resthour) {
            Intent intent = new Intent(RestHourActivity.this, RestHourActivity.class);
            startActivity(intent);
        }

        if(item.getItemId()== R.id.assign) {
            Intent intent = new Intent(RestHourActivity.this, AssignedJobActivity.class);
            startActivity(intent);
        }

        if(item.getItemId()== R.id.unassign) {
            Intent intent = new Intent(RestHourActivity.this, UnassignedJobActivity.class);
            startActivity(intent);
        }

        if(item.getItemId()== R.id.complete) {
            Intent intent = new Intent(RestHourActivity.this, CompleteActivity.class);
            startActivity(intent);
        }

        if(item.getItemId()== R.id.incomplete) {
            Intent intent5 = new Intent(RestHourActivity.this, IncompleteActivity.class);
            startActivity(intent5);
        }

        if(item.getItemId()== R.id.pending) {
            Intent intent5 = new Intent(RestHourActivity.this, PendingActivity.class);
            startActivity(intent5);
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}