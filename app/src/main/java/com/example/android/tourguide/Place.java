package com.example.android.tourguide;

public class Place {

    private String mName, mAddress;
    private int mImageResourceId;

    public Place(String Name, String Address, int ImageId){
        mName = Name;
        mAddress = Address;
        mImageResourceId = ImageId;

    }

    public String getmName() {
        return mName;
    }

    public String getmAddress() {
        return mAddress;
    }
    public int getmImageResourceId(){
        return mImageResourceId;
    }

}
