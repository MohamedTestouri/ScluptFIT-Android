package com.esprit.scluptfit.entities;

import java.util.Date;

public class Run {

    private String idRuns;
    private Double calories;
    private Double distance;
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
