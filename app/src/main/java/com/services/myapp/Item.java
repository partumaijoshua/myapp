package com.services.myapp;

public class Item {
String Email,Date,Phone,Constituency,kitambulisho,Jina;

    public Item(String email, String date, String phone, String constituency, String kitambulisho, String jina) {
        Email = email;
        Date = date;
        Phone = phone;
        Constituency = constituency;
        this.kitambulisho = kitambulisho;
        Jina = jina;
    }

    public Item() {
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getConstituency() {
        return Constituency;
    }

    public void setConstituency(String constituency) {
        Constituency = constituency;
    }

    public String getKitambulisho() {
        return kitambulisho;
    }

    public void setKitambulisho(String kitambulisho) {
        this.kitambulisho = kitambulisho;
    }

    public String getJina() {
        return Jina;
    }

    public void setJina(String jina) {
        Jina = jina;
    }

}
