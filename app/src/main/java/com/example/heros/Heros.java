package com.example.heros;

public class Hero {

    private String name;
    private String description;
    private String superpower;
    private int ranking;
    private String image;

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSuperpower(String superpower) {
        this.superpower = superpower;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public void setImage(String image) {
        this.image = image;
    }

    ////////////////////////////////////////////

    public String getName()
    {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getSuperpower() {
        return superpower;
    }

    public int getRanking() {
        return ranking;
    }

    public String getImage() {
        return image;
    }
}
