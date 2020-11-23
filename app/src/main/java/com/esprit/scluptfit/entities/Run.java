package com.esprit.scluptfit.entities;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Run {
    @SerializedName("_id")
    private String idRuns;
    @SerializedName("calories")
    private Double calories;
    @SerializedName("distance")
    private Double distance;
    @SerializedName("duration")
    private Date duration;

    public Run(String idRuns, Double calories, Double distance, Date duration) {
        this.idRuns = idRuns;
        this.calories = calories;
        this.distance = distance;
        this.duration = duration;
    }

    public Run(Double calories, Double distance) {
        this.calories = calories;
        this.distance = distance;

    }

    public String getIdRuns() {
        return idRuns;
    }

    public void setIdRuns(String idRuns) {
        this.idRuns = idRuns;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Date getDuration() {
        return duration;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
    }
}
