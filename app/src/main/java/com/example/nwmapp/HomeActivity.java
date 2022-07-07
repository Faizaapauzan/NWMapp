package com.example.nwmapp;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageView btMenu;
    RecyclerView recyclerView;
    static ArrayList<String> arrayList = new ArrayList<>();
    MainAdapter adapter;

    public static void closeDrawer(DrawerLayout drawerLayout) {

        if (drawerLayout.isDrawerOpen((GravityCompat.START))){

            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        drawerLayout = findViewById(R.id.drawerLayout);
        btMenu = findViewById(R.id.bt_menu);
        recyclerView = findViewById(R.id.recyler_view);

        arrayList.clear();

        arrayList.add("Home");
        arrayList.add("Attendance");
        arrayList.add("Rest Hour");
        arrayList.add("Report Off");
        arrayList.add("Assigned Job");
        arrayList.add("Unassign Job");
        arrayList.add("Pending");
        arrayList.add("Incomplete");
        arrayList.add("Completed");
        arrayList.add("Log Out");

        adapter = new MainAdapter(this,arrayList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapter);

        btMenu.setOnClickListener(view -> drawerLayout.openDrawer(GravityCompat.START));


    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }
}