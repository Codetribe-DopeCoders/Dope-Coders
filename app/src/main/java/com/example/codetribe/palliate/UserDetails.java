package com.example.codetribe.palliate;

/**
 * Created by codetribe on 8/28/2017.
 */

public class UserDetails {

    private String mUserName;
    private String mMail;
    private String mPasswors;
    private String mContactNumber;
    private String mSocialNumber;
    private String mLevelOneContacOne;
    private String mLevelTwoContactTwo;
    private String mLeve2OneContacOne;
    private String mLeve2TwoContactTwo;


    //user details public constructor
    public UserDetails(String mUserName, String mMail, String mPasswors, String mContactNumber, String mSocialNumber, String mLevelOneContacOne, String mLevelTwoContactTwo, String mLeve2OneContacOne, String mLeve2TwoContactTwo) {
        this.mUserName = mUserName;
        this.mMail = mMail;
        this.mPasswors = mPasswors;
        this.mContactNumber = mContactNumber;
        this.mSocialNumber = mSocialNumber;
        this.mLevelOneContacOne = mLevelOneContacOne;
        this.mLevelTwoContactTwo = mLevelTwoContactTwo;
        this.mLeve2OneContacOne = mLeve2OneContacOne;
        this.mLeve2TwoContactTwo = mLeve2TwoContactTwo;
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

    public String getmSocialNumber() {
        return mSocialNumber;
    }

    public void setmSocialNumber(String mSocialNumber) {
        this.mSocialNumber = mSocialNumber;
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

    public String getmLeve2OneContacOne() {
        return mLeve2OneContacOne;
    }

    public void setmLeve2OneContacOne(String mLeve2OneContacOne) {
        this.mLeve2OneContacOne = mLeve2OneContacOne;
    }

    public String getmLeve2TwoContactTwo() {
        return mLeve2TwoContactTwo;
    }

    public void setmLeve2TwoContactTwo(String mLeve2TwoContactTwo) {
        this.mLeve2TwoContactTwo = mLeve2TwoContactTwo;
    }
}
