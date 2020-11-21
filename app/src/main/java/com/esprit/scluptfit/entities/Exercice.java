package com.esprit.scluptfit.entities;

public class Exercice {
    private String idExercice;
    private String name;
    private String description;
    private String category;
    private String model;
    private String audio;
    private String image;

    public Exercice(String idExercice, String name, String description, String category, String model, String audio, String image) {
        this.idExercice = idExercice;
        this.name = name;
        this.description = description;
        this.category = category;
        this.model = model;
        this.audio = audio;
        this.image = image;
    }

    public String getIdExercice() {
        return idExercice;
    }

    public void setIdExercice(String idExercice) {
        this.idExercice = idExercice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
