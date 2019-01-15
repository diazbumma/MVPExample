package com.diazbumma.mvpexample.main.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hero {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("realname")
    @Expose
    private String realName;

    @SerializedName("team")
    @Expose
    private String team;

    @SerializedName("firstappearance")
    @Expose
    private String firstAppearance;

    @SerializedName("createdby")
    @Expose
    private String createdBy;

    @SerializedName("publisher")
    @Expose
    private String publisher;

    @SerializedName("imageurl")
    @Expose
    private String imageUrl;

    @SerializedName("bio")
    @Expose
    private String bio;

    public Hero(
            String name,
            String realName,
            String team,
            String firstAppearance,
            String createdBy,
            String publisher,
            String imageUrl,
            String bio) {
        this.name = name;
        this.realName =realName;
        this.team = team;
        this.firstAppearance = firstAppearance;
        this.createdBy = createdBy;
        this.publisher = publisher;
        this.imageUrl = imageUrl;
        this.bio = bio;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setFirstAppearance(String firstAppearance) {
        this.firstAppearance = firstAppearance;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getName() {
        if (this.name != null) {
            return name;
        }
        return "";
    }

    public String getRealName() {
        if (this.realName != null) {
            return realName;
        }
        return "";
    }

    public String getTeam() {
        if (this.team != null) {
            return team;
        }
        return "";
    }

    public String getFirstAppearance() {
        if (this.firstAppearance != null) {
            return firstAppearance;
        }
        return "";
    }

    public String getCreatedBy() {
        if (this.createdBy != null) {
            return createdBy;
        }
        return "";
    }

    public String getPublisher() {
        if (this.publisher != null) {
            return publisher;
        }
        return "";
    }

    public String getImageUrl() {
        if (this.imageUrl != null) {
            return imageUrl;
        }
        return "";
    }

    public String getBio() {
        if (this.bio != null) {
            return bio;
        }
        return "";
    }
}
