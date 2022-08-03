package com.example.nwmapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nwmapp.API.RetrofitClient;
import com.example.nwmapp.Storage.SharedPrefManager;
import com.example.nwmapp.models.DefaultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText Username;
    private EditText Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Username = findViewById(R.id.Username);
        Password = findViewById(R.id.Password);

        findViewById(R.id.LoginButton).setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        if(SharedPrefManager.getInstance(this).isLoggedIn()){
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

    private void techLogin() {

        String username = Username.getText().toString().trim();
        String password = Password.getText().toString().trim();

        if (username.isEmpty()) {
            Username.setError("Username is required");
            Username.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            Password.setError("Password required");
            Password.requestFocus();
            return;
        }

        Call<DefaultResponse> call = RetrofitClient
                .getInstance()
                .getAPI()
                .getTechnician (username, password);

        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {

                DefaultResponse defaultResponse = response.body();

                if (response.code()==200) {
                    SharedPrefManager.getInstance(MainActivity.this)
                            .saveUser(defaultResponse.getUser());

                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }

                else {
                    Toast.makeText(MainActivity.this,"Username & Password does not match", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure (Call <DefaultResponse> call, Throwable t){
                Toast.makeText(MainActivity.this,"Login Failed", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.LoginButton) {
            techLogin();
        }
    }
}