package com.example.tourism;

public class PlaceToGo {
    private Integer imageId;
    private String name, description;
    public PlaceToGo(Integer imageId, String name, String description){
        this.imageId = imageId;
        this.name = name;
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
}
