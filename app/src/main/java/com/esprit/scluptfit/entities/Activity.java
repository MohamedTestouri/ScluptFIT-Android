package com.esprit.scluptfit.entities;

import com.google.gson.annotations.SerializedName;

public class Activity {
    @SerializedName("_id")
    private String idActivity;
    @SerializedName("sum")
    private int sum;
    @SerializedName("categoryExercice")
    private String categoryExercice;

    public Activity(String idActivity, int sum, String categoryExercice) {
        this.idActivity = idActivity;
        this.sum = sum;
        this.categoryExercice = categoryExercice;
    }

    public Activity(int sum) {
        this.sum = sum;
    }

    public String getIdActivity() {
        return idActivity;
    }

    public void setIdActivity(String idActivity) {
        this.idActivity = idActivity;
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
