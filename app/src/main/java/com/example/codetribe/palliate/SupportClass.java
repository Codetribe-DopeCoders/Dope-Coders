package com.example.codetribe.palliate;

/**
 * Created by codetribe on 9/1/2017.
 */

public class SupportClass {

    private int mImage;
    private String mName;
    private String mLocation;
    private String mOccupation;
    private String mContacts;

    public SupportClass(String mName, String mContacts) {
        this.mName = mName;
        this.mContacts = mContacts;
    }
    //private int mAudioResourceId;

    public SupportClass(int photo, String mName, String mLocation, String mOccupation, String mContacts) {

        this.mImage = photo;
        this.mName = mName;
        this.mLocation = mLocation;
        this.mOccupation = mOccupation;
        this.mContacts = mContacts;
        //this.mAudioResourceId=mAudioResourceId;
    }

    public int getPhoto() {
        return mImage;
    }

    public void setPhoto(int photo) {
        this.mImage = photo;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmLocation() {
        return mLocation;
    }

    public void setmLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    public String getmOccupation() {
        return mOccupation;
    }

    public void setmOccupation(String mOccupation) {
        this.mOccupation = mOccupation;
    }

    public String getmContacts() {
        return mContacts;
    }

    public void setmContacts(String mContacts) {
        this.mContacts = mContacts;
    }

//    public int getmAudioResourceId() {
//        return mAudioResourceId;
//    }
//
//    public void setmAudioResourceId(int mAudioResourceId) {
//        this.mAudioResourceId = mAudioResourceId;
//    }
}
