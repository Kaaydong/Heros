package com.example.hero;


import android.os.Parcel;
import android.os.Parcelable;

public class Heros implements Parcelable {

    private String name;
    private String description;
    private String superpower;
    private int ranking;
    private String image;

    @Override
    public String toString()
    {
        return name + " " + description + " " + superpower;
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeString(this.superpower);
        dest.writeInt(this.ranking);
        dest.writeString(this.image);
    }

    public Heros() {
    }

    protected Heros(Parcel in) {
        this.name = in.readString();
        this.description = in.readString();
        this.superpower = in.readString();
        this.ranking = in.readInt();
        this.image = in.readString();
    }

    public static final Parcelable.Creator<Heros> CREATOR = new Parcelable.Creator<Heros>() {
        @Override
        public Heros createFromParcel(Parcel source) {
            return new Heros(source);
        }

        @Override
        public Heros[] newArray(int size) {
            return new Heros[size];
        }
    };
}
