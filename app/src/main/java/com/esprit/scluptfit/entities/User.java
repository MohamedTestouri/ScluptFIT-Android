package com.esprit.scluptfit.entities;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;

public class User {
    @SerializedName("_id")
    private String idUser;
    @SerializedName("fullName")
    private String fullName;
    @SerializedName("phone")
    private String phone;
    @SerializedName("birthday")
    private Date birthday;
    @SerializedName("sexe")
    private String sexe;
    @SerializedName("password")
    private String password;
    @SerializedName("email")
    private String email;
    @SerializedName("healthInformation")
    private ArrayList<HealthInformation> HealthInformationArrayList;
    @SerializedName("runs")
    private ArrayList<Run> RunArrayList; //Run [] run;
    @SerializedName("activities")
    private ArrayList<Activity> activitiesArrayList;

    public User(String email, String password) {
        this.password = password;
        this.email = email;
    }

    public User(String idUser, String fullName, String phone, Date birthday, String sexe, String password, String email, ArrayList<HealthInformation> healthInformationArrayList, ArrayList<Run> runArrayList, ArrayList<Activity> activitiesArrayList) {
        this.idUser = idUser;
        this.fullName = fullName;
        this.phone = phone;
        this.birthday = birthday;
        this.sexe = sexe;
        this.password = password;
        this.email = email;
        HealthInformationArrayList = healthInformationArrayList;
        RunArrayList = runArrayList;
        this.activitiesArrayList = activitiesArrayList;
    }

    public User(String fullName, String phone, Date birthday, String sexe, String password, String email) {
        this.fullName = fullName;
        this.phone = phone;
        this.birthday = birthday;
        this.sexe = sexe;
        this.password = password;
        this.email = email;
    }


    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<HealthInformation> getHealthInformationArrayList() {
        return HealthInformationArrayList;
    }

    public void setHealthInformationArrayList(ArrayList<HealthInformation> healthInformationArrayList) {
        HealthInformationArrayList = healthInformationArrayList;
    }

    public ArrayList<Run> getRunArrayList() {
        return RunArrayList;
    }

    public void setRunArrayList(ArrayList<Run> runArrayList) {
        RunArrayList = runArrayList;
    }

    public ArrayList<Activity> getActivitiesArrayList() {
        return activitiesArrayList;
    }

    public void setActivitiesArrayList(ArrayList<Activity> activitiesArrayList) {
        this.activitiesArrayList = activitiesArrayList;
    }
}
