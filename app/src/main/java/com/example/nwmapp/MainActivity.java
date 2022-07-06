package com.example.nwmapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        EditText Username =(EditText) findViewById(R.id.Username);
        EditText Password =(EditText) findViewById(R.id.Password);

        AppCompatButton LoginButton = (AppCompatButton) findViewById(R.id.LoginButton);

        //admin and admin

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Username.getText().toString().equals("admin") && Password.getText().toString().equals("admin123"))
                {
                    //correct
                    Toast.makeText(MainActivity.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();

                    openNewActivity();
                }

                else if (Username.getText().toString().equals("keong") && Password.getText().toString().equals("keong123"))
                {
                    //correct
                    Toast.makeText(MainActivity.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();

                    openKeong();
                }

                else
                {
                    //incorrect
                    Toast.makeText(MainActivity.this,"LOGIN FAILED !!!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void openKeong() {
        Intent intent = new Intent(this, HomeKeong.class);
        startActivity(intent);
    }

    private void openNewActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}