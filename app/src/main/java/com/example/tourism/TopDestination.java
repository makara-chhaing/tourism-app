package com.example.tourism;

import android.os.Parcel;
import android.os.Parcelable;

public class TopDestination implements Parcelable {
    private Integer imageId;

    public TopDestination(int imageID){
        this.imageId = imageID;
    }

    protected TopDestination(Parcel in) {
        if (in.readByte() == 0) {
            imageId = null;
        } else {
            imageId = in.readInt();
        }
    }

    public static final Creator<TopDestination> CREATOR = new Creator<TopDestination>() {
        @Override
        public TopDestination createFromParcel(Parcel in) {
            return new TopDestination(in);
        }

        @Override
        public TopDestination[] newArray(int size) {
            return new TopDestination[size];
        }
    };

    public Integer getImageId() {
        return imageId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (imageId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(imageId);
        }
    }
}
