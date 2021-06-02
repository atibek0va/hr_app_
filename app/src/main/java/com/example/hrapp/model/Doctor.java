package com.example.hrapp.model;

public class Doctor {
    int photo;
    String name;
    String exper;
    String number;

    public Doctor(int photo, String name, String exper, String number) {
        this.photo = photo;
        this.name = name;
        this.exper = exper;
        this.number = number;
    }

    public int getPhoto(){
        return photo;
    }

    public int setPhoto(int photo){
        return photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExper() {
        return exper;
    }

    public void setExper(String exper) {
        this.exper = exper;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
