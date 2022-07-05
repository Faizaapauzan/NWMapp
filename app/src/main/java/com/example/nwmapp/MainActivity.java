package com.example.nwmapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnNext;
    Button btnJob;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnNext=findViewById(R.id.btnNext);
        btnNext.setOnClickListener(view -> openNewActivity());

        btnJob=findViewById(R.id.btnJob);
        btnJob.setOnClickListener(view -> openNewActivity());



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bottom_nav, menu);
        return true;
    }

    public void openNewActivity() {
        Intent intent = new Intent(this, HomeKeong.class);
        startActivity(intent);

        Intent intent1 = new Intent(this, HomeActivity.class);
        startActivity(intent1);



    }


}