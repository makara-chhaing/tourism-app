package com.example.tourism;

import java.io.Serializable;

public class PlaceToGo implements Serializable {
    private Integer imageId;
    private String name, location, description;
    public PlaceToGo(Integer imageId, String name, String location, String description){
        this.imageId = imageId;
        this.name = name;
        this.location = location;
        this.description = description;
    }

    public Integer getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }
}
