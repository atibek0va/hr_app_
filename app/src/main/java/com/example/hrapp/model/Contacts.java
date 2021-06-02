package com.example.hrapp.model;

public class Contacts {
    int contactPhoto;
    String contactName;
    String contactPost;
    String contactNumber;
    String contactEmail;

    public Contacts(){}

    public int getContactPhoto() {
        return contactPhoto;
    }

    public void setContactPhoto(int contactPhoto) {
        this.contactPhoto = contactPhoto;
    }

    public Contacts(int contactPhoto, String contactName, String contactPost, String contactNumber, String contactEmail) {
        this.contactPhoto = contactPhoto;
        this.contactName = contactName;
        this.contactPost = contactPost;
        this.contactNumber = contactNumber;
        this.contactEmail = contactEmail;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPost() {
        return contactPost;
    }

    public void setContactPost(String contactPost) {
        this.contactPost = contactPost;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
}
