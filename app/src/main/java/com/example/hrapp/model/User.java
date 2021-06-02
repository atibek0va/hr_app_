package com.example.hrapp.model;

public class User {
    String name;
    String email;
    String password;
    String hour;
    String curatorship;
    String addWorks;
    String insta;
    String tele;
    String mail;
    String phone;

    public User(){}

    public User(String name, String email, String password, String hour, String curatorship, String addWorks, String insta, String tele, String mail, String phone) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.hour = hour;
        this.curatorship = curatorship;
        this.addWorks = addWorks;
        this.insta = insta;
        this.tele = tele;
        this.mail = mail;
        this.phone = phone;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getCuratorship() {
        return curatorship;
    }

    public void setCuratorship(String number) {
        this.curatorship = curatorship;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddWorks() {
        return addWorks;
    }

    public void setAddWorks(String addWorks) {
        this.addWorks = addWorks;
    }

    public String getInsta() {
        return insta;
    }

    public void setInsta(String insta) {
        this.insta = insta;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
