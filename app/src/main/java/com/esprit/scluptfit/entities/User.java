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
    public ArrayList<HealthInformation> healthInformation;
    @SerializedName("runs")
    public ArrayList<Run> run;
    @SerializedName("activities")
    public ArrayList<Activity> activity;

    public static class HealthInformation {
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

    public static class Run {
        @SerializedName("_id")
        private String idRuns;
        @SerializedName("calories")
        private Double calories;
        @SerializedName("distance")
        private Double distance;
        @SerializedName("duration")
        private Double duration;

        public Run(String idRuns, Double calories, Double distance, Double duration) {
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

        public Double getDuration() {
            return duration;
        }

        public void setDuration(Double duration) {
            this.duration = duration;
        }
    }

    public static class Activity {
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

    public User(String idUser, String fullName, String phone, Date birthday, String sexe, String password, String email, ArrayList<HealthInformation> healthInformation, ArrayList<Run> run, ArrayList<Activity> activity) {
        this.idUser = idUser;
        this.fullName = fullName;
        this.phone = phone;
        this.birthday = birthday;
        this.sexe = sexe;
        this.password = password;
        this.email = email;
        this.healthInformation = healthInformation;
        this.run = run;
        this.activity = activity;
    }

    public User(String fullName, String phone, Date birthday, String sexe, String password, String email) {
        this.fullName = fullName;
        this.phone = phone;
        this.birthday = birthday;
        this.sexe = sexe;
        this.password = password;
        this.email = email;
    }

    public User(String password, String email) {
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

    public ArrayList<HealthInformation> getHealthInformation() {
        return healthInformation;
    }

    public void setHealthInformation(ArrayList<HealthInformation> healthInformation) {
        this.healthInformation = healthInformation;
    }

    public ArrayList<Run> getRun() {
        return run;
    }

    public void setRun(ArrayList<Run> run) {
        this.run = run;
    }

    public ArrayList<Activity> getActivity() {
        return activity;
    }

    public void setActivity(ArrayList<Activity> activity) {
        this.activity = activity;
    }

}
