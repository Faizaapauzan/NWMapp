package com.example.nwmapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class User {

    @SerializedName("staffregister_id")
    @Expose
    private Integer staffregisterId;
    @SerializedName("staff_fullname")
    @Expose
    private String staffFullname;
    @SerializedName("employee_id")
    @Expose
    private String employeeId;
    @SerializedName("staff_phone")
    @Expose
    private Integer staffPhone;
    @SerializedName("staff_email")
    @Expose
    private String staffEmail;
    @SerializedName("staff_position")
    @Expose
    private String staffPosition;
    @SerializedName("staff_department")
    @Expose
    private String staffDepartment;
    @SerializedName("staff_group")
    @Expose
    private String staffGroup;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("technician_group")
    @Expose
    private String technicianGroup;
    @SerializedName("technician_rank")
    @Expose
    private String technicianRank;
    @SerializedName("job_ability")
    @Expose
    private String jobAbility;
    @SerializedName("tech_avai")
    @Expose
    private String techAvai;
    @SerializedName("staffregistercreated_by")
    @Expose
    private String staffregistercreatedBy;
    @SerializedName("staffregistercreated_at")
    @Expose
    private String staffregistercreatedAt;
    @SerializedName("staffregisterlastmodify_by")
    @Expose
    private String staffregisterlastmodifyBy;
    @SerializedName("staffregisterlastmodify_at")
    @Expose
    private String staffregisterlastmodifyAt;

    public User(int staffregister_id, String username, String password, String technician_rank) {

    }

    public Integer getStaffregisterId() {
        return staffregisterId;
    }

    public void setStaffregisterId(Integer staffregisterId) {
        this.staffregisterId = staffregisterId;
    }

    public String getStaffFullname() {
        return staffFullname;
    }

    public void setStaffFullname(String staffFullname) {
        this.staffFullname = staffFullname;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(Integer staffPhone) {
        this.staffPhone = staffPhone;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    public String getStaffPosition() {
        return staffPosition;
    }

    public void setStaffPosition(String staffPosition) {
        this.staffPosition = staffPosition;
    }

    public String getStaffDepartment() {
        return staffDepartment;
    }

    public void setStaffDepartment(String staffDepartment) {
        this.staffDepartment = staffDepartment;
    }

    public String getStaffGroup() {
        return staffGroup;
    }

    public void setStaffGroup(String staffGroup) {
        this.staffGroup = staffGroup;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTechnicianGroup() {
        return technicianGroup;
    }

    public void setTechnicianGroup(String technicianGroup) {
        this.technicianGroup = technicianGroup;
    }

    public String getTechnicianRank() {
        return technicianRank;
    }

    public void setTechnicianRank(String technicianRank) {
        this.technicianRank = technicianRank;
    }

    public String getJobAbility() {
        return jobAbility;
    }

    public void setJobAbility(String jobAbility) {
        this.jobAbility = jobAbility;
    }

    public String getTechAvai() {
        return techAvai;
    }

    public void setTechAvai(String techAvai) {
        this.techAvai = techAvai;
    }

    public String getStaffregistercreatedBy() {
        return staffregistercreatedBy;
    }

    public void setStaffregistercreatedBy(String staffregistercreatedBy) {
        this.staffregistercreatedBy = staffregistercreatedBy;
    }

    public String getStaffregistercreatedAt() {
        return staffregistercreatedAt;
    }

    public void setStaffregistercreatedAt(String staffregistercreatedAt) {
        this.staffregistercreatedAt = staffregistercreatedAt;
    }

    public String getStaffregisterlastmodifyBy() {
        return staffregisterlastmodifyBy;
    }

    public void setStaffregisterlastmodifyBy(String staffregisterlastmodifyBy) {
        this.staffregisterlastmodifyBy = staffregisterlastmodifyBy;
    }

    public String getStaffregisterlastmodifyAt() {
        return staffregisterlastmodifyAt;
    }

    public void setStaffregisterlastmodifyAt(String staffregisterlastmodifyAt) {
        this.staffregisterlastmodifyAt = staffregisterlastmodifyAt;
    }

}