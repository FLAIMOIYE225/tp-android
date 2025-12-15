package com.example.map_application.model;

public class Ville {

    private String nom;
    private int imageResId;
    private String description;

    public Ville(String nom, int imageResId, String description) {
        this.nom = nom;
        this.imageResId = imageResId;
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getDescription() {
        return description;
    }
}
