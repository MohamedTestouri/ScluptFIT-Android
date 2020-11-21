package com.esprit.scluptfit.entities;

import java.util.Date;

public class HealthInformation {

    private String idHealthInformation;
    private Double calories;
    private Date date;
    private Double weight;
    private Double height;

    public HealthInformation(String idHealthInformation, Double calories, Date date, Double weight, Double height) {
        this.idHealthInformation = idHealthInformation;
        this.calories = calories;
        this.date = date;
        this.weight = weight;
        this.height = height;
    }

    public HealthInformation(Double weight, Double height) {
        this.weight = weight;
        this.height = height;
    }

    public HealthInformation(Double calories, Double weight, Double height) {
        this.calories = calories;
        this.weight = weight;
        this.height = height;
    }

    public String getIdHealthInformation() {
        return idHealthInformation;
    }

    public void setIdHealthInformation(String idHealthInformation) {
        this.idHealthInformation = idHealthInformation;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }
}
