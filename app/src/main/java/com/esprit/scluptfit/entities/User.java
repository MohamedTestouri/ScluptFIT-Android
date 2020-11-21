package com.esprit.scluptfit.entities;

import java.util.ArrayList;
import java.util.Date;

public class User {

    private String idUser;
    private String fullName;
    private String phone;
    private Date birthday;
    private String sexe;
    private String password;
    private String email;

    private ArrayList<HealthInformation> HealthInformationArrayList = new ArrayList<>();
    private ArrayList<Run> RunArrayList = new ArrayList<>();
    private ArrayList<Activitie> ActivitieArrayList = new ArrayList<>();

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

    public ArrayList<Activitie> getActivitieArrayList() {
        return ActivitieArrayList;
    }

    public void setActivitieArrayList(ArrayList<Activitie> activitieArrayList) {
        ActivitieArrayList = activitieArrayList;
    }
}
