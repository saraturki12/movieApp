package com.project.movie.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("comedy")
public class ComedyMovie extends Movie{
    private String humorType;
    private String mainActor;

    public String getHumorType() {

        return humorType;
    }

    public String getMainActor() {
        return mainActor;
    }

    public void setMainActor(String mainActor) {
        this.mainActor = mainActor;
    }



    public void setHumorType(String humorType) {
        this.humorType = humorType;
    }
}
