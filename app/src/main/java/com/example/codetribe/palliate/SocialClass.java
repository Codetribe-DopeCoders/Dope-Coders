package com.example.codetribe.palliate;

/**
 * Created by codetribe on 12/5/2017.
 */


public class SocialClass {

    private String name;
    private String occupation;
    private String location;
    private int img_id;
    private String moreDetails;
    private String infoDetails;
    private String phoneNumber;
    private String emailDetails;

    public SocialClass(String name, String occupation, String location, int img_id, String moreDetails, String infoDetails, String phoneNumber, String emailDetails) {
        this.name = name;
        this.occupation = occupation;
        this.location = location;
        this.img_id = img_id;
        this.moreDetails = moreDetails;
        this.infoDetails = infoDetails;
        this.phoneNumber = phoneNumber;
        this.emailDetails = emailDetails;
    }

    public String getEmailDetails() {
        return emailDetails;
    }

    public void setEmailDetails(String emailDetails) {
        this.emailDetails = emailDetails;
    }



    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    public String getInfoDetails() {
        return infoDetails;
    }

    public void setInfoDetails(String infoDetails) {
        this.infoDetails = infoDetails;
    }


    public String getMoreDetails() {
        return moreDetails;
    }

    public void setMoreDetails(String moreDetails) {
        this.moreDetails = moreDetails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String age) {
        this.occupation = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getImg_id() {
        return img_id;
    }

    public void setImg_id(int img_id) {
        this.img_id = img_id;
    }
}
