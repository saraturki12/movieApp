package com.project.movie.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("action")
public class ActionMovie extends Movie {

    private String mainActor;


    public void setMainActor(String mainActor) {
        this.mainActor = mainActor;
    }

    public String getMainActor() {
        return mainActor;
    }


}
