package com.example.codetribe.palliate;

/**
 * Created by codetribe on 8/28/2017.
 */

public class UserDetails {

    private String mUserName;
    private String mMail;
    private String mPasswors;
    private String mContactNumber;
    private String mLevelOneContacOne;
    private String mLevelTwoContactTwo;




    //user details public constructor
    public UserDetails(String mUserName, String mMail, String mPasswors, String mContactNumber, String mLevelOneContacOne, String mLevelTwoContactTwo) {
        this.mUserName = mUserName;
        this.mMail = mMail;
        this.mPasswors = mPasswors;
        this.mContactNumber = mContactNumber;
        this.mLevelOneContacOne = mLevelOneContacOne;
        this.mLevelTwoContactTwo = mLevelTwoContactTwo;

    }

    public UserDetails(String mUserName, String mMail, String mPasswors, String mContactNumber) {
        this.mUserName = mUserName;
        this.mMail = mMail;
        this.mPasswors = mPasswors;
        this.mContactNumber = mContactNumber;


    }

    /**
     * user details public setters and getters
     **/

    public String getmUserName() {
        return mUserName;
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public String getmMail() {
        return mMail;
    }

    public void setmMail(String mMail) {
        this.mMail = mMail;
    }

    public String getmPasswors() {
        return mPasswors;
    }

    public void setmPasswors(String mPasswors) {
        this.mPasswors = mPasswors;
    }

    public String getmContactNumber() {
        return mContactNumber;
    }

    public void setmContactNumber(String mContactNumber) {
        this.mContactNumber = mContactNumber;
    }

    public String getmLevelOneContacOne() {
        return mLevelOneContacOne;
    }

    public void setmLevelOneContacOne(String mLevelOneContacOne) {
        this.mLevelOneContacOne = mLevelOneContacOne;
    }

    public String getmLevelTwoContactTwo() {
        return mLevelTwoContactTwo;
    }

    public void setmLevelTwoContactTwo(String mLevelTwoContactTwo) {
        this.mLevelTwoContactTwo = mLevelTwoContactTwo;
    }



}
