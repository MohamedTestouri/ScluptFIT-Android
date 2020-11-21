package com.esprit.scluptfit.entities;

public class Activitie {

    private String idActivitie;
    private int sum;
    private String categoryExercice;

    public Activitie(String idActivitie, int sum, String categoryExercice) {
        this.idActivitie = idActivitie;
        this.sum = sum;
        this.categoryExercice = categoryExercice;
    }

    public Activitie(int sum) {
        this.sum = sum;
    }

    public String getIdActivitie() {
        return idActivitie;
    }

    public void setIdActivitie(String idActivitie) {
        this.idActivitie = idActivitie;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getCategoryExercice() {
        return categoryExercice;
    }

    public void setCategoryExercice(String categoryExercice) {
        this.categoryExercice = categoryExercice;
    }
}
