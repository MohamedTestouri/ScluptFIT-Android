package com.esprit.scluptfit.entities;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class HealthInformation {
    @SerializedName("_id")
    private String idHealthInformation;
    @SerializedName("calories")
    private Double calories;
    @SerializedName("date")
    private Date date;
    @SerializedName("weight")
    private Double weight;
    @SerializedName("height")
    private Double height;
    @SerializedName("steps")
    private int steps;

    public HealthInformation(String idHealthInformation, Double calories, Date date, Double weight, Double height, int steps) {
        this.idHealthInformation = idHealthInformation;
        this.calories = calories;
        this.date = date;
        this.weight = weight;
        this.height = height;
        this.steps = steps;
    }

    public HealthInformation(Double weight, Double height) {
        this.weight = weight;
        this.height = height;
    }

    public HealthInformation(Double calories, Double weight, Double height, int steps) {
        this.calories = calories;
        this.weight = weight;
        this.height = height;
        this.steps = steps;
    }

    public String getIdHealthInformation() {
        return idHealthInformation;
    }

    public void setIdHealthInformation(String idHealthInformation) {
        this.idHealthInformation = idHealthInformation;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
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
