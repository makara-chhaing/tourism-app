package com.example.tourism;

public class TopDestination {
    private Integer imageId;
    private PlaceToGo place;
    public TopDestination(int imageID, PlaceToGo place){
        this.imageId = imageID;
        this.place = place;
    }


    public PlaceToGo getPlace() {
        return place;
    }


    public Integer getImageId() {
        return imageId;
    }

}
