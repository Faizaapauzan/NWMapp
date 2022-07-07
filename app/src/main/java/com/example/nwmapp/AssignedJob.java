package com.example.nwmapp;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AssignedJob extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageView btMenu;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assigned_job);


        drawerLayout = findViewById(R.id.drawerLayout);
        btMenu = findViewById(R.id.bt_menu);
        recyclerView = findViewById(R.id.recyler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(new MainAdapter(this, HomeActivity.arrayList));

        btMenu.setOnClickListener(view -> drawerLayout.openDrawer(GravityCompat.START));

    }

    @Override
    protected void onPause() {
        super.onPause();

        HomeActivity.closeDrawer(drawerLayout);
    }
}