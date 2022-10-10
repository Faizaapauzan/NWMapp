package com.example.nwmapp.models;

import com.google.gson.annotations.SerializedName;

public class JobAssign {

    @SerializedName("job_priority")
    private String job_priority;

    @SerializedName("job_order_number")
    private String job_order_number;

    @SerializedName("customer_name")
    private String customer_name;

    @SerializedName("job_description")
    private String job_description;

    @SerializedName("machine_name")
    private String machine_name;

    @SerializedName("machine_type")
    private String machine_type;

    @SerializedName("serial_number")
    private String serial_number;

    @SerializedName("reason")
    private String reason;

    @SerializedName("job_assign")
    private String job_assign;

    public JobAssign(String job_priority, String job_order_number, String customer_name, String job_description, String machine_name, String machine_type, String serial_number, String reason) {
        this.job_priority = job_priority;
        this.job_order_number = job_order_number;
        this.customer_name = customer_name;
        this.job_description = job_description;
        this.machine_name = machine_name;
        this.machine_type = machine_type;
        this.serial_number = serial_number;
        this.reason = reason;
        this.job_assign = job_assign;
    }

    public String getJob_priority() {
        return job_priority;
    }

    public void setJob_priority(String job_priority) {
        this.job_priority = job_priority;
    }

    public String getJob_order_number() {
        return job_order_number;
    }

    public void setJob_order_number(String job_order_number) {
        this.job_order_number = job_order_number;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getJob_description() {
        return job_description;
    }

    public void setJob_description(String job_description) {
        this.job_description = job_description;
    }

    public String getMachine_name() {
        return machine_name;
    }

    public void setMachine_name(String machine_name) {
        this.machine_name = machine_name;
    }

    public String getMachine_type() {
        return machine_type;
    }

    public void setMachine_type(String machine_type) {
        this.machine_type = machine_type;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getAssign() {
        return job_assign;
    }

    public void setAssign(String job_assign) {
        this.job_assign = job_assign;
    }
}
