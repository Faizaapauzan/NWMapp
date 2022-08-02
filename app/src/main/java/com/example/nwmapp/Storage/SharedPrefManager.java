package com.example.nwmapp.Storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.nwmapp.models.User;

public class SharedPrefManager {

    private static final String SHARED_PREF_NAME = "my_shared_preff";
    private SharedPreferences sharedPreferences;
    Context context;
    private SharedPreferences.Editor editor;

    private static SharedPrefManager mInstance;
    private final Context mCtx;

    public SharedPrefManager(Context mCtx) {
        this.mCtx = mCtx;
    }



    public static synchronized SharedPrefManager getInstance(Context mCtx) {
        if(mInstance == null){
            mInstance = new SharedPrefManager(mCtx);
        }
        return mInstance;
    }

    public void saveUser (User user) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("staffregister_id", user.getStaffregisterId());
        editor.putString("username", user.getUsername());
        editor.putString("password", user.getPassword());
        editor.putString("technician_rank", user.getTechnicianRank());

        editor.apply();
    }

    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt("staffregister_id", -1) != -1;
    }

    public User getUser(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new User(
                sharedPreferences.getInt("staffregister_id", -1),
                sharedPreferences.getString("username", null),
                sharedPreferences.getString("password", null),
                sharedPreferences.getString("technician_rank", null)
        );
    }


    public void logout(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        editor.clear();
        editor.apply();

    }
    public void  clear (){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
