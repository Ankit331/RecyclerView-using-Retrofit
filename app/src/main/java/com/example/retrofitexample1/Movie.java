package com.example.retrofitexample1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Movie {

    public Movie(String title, String image) {
        this.title = title;
        this.image = image;
    }

    @SerializedName("id")
    private String id;

    @SerializedName("image")
    private String image;

    @SerializedName("title")
    private String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}

