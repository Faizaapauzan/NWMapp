package com.example.nwmapp.models;

public class User {

    private final int staffregister_id;
    private final String username;
    private final String password;
    private final String technician_rank;

    public User(int staffregister_id, String username, String password, String technician_rank) {
        this.staffregister_id = staffregister_id;
        this.username = username;
        this.password = password;
        this.technician_rank = technician_rank;
    }

    public int getStaffregister_id() {
        return staffregister_id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getTechnician_rank() {
        return technician_rank;
    }
}
