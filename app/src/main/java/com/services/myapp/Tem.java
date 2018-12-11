package com.services.myapp;

public class Tem {
    String Name, Phone, ID, Reason,key;

    public Tem(String name, String phone, String ID, String reason, String key) {
        Name = name;
        Phone = phone;
        this.ID = ID;
        Reason = reason;
        this.key = key;
    }

    public Tem() {
    }

    public String getName() {
        return Name;
    }

    public String getPhone() {
        return Phone;
    }

    public String getID() {
        return ID;
    }

    public String getReason() {
        return Reason;
    }

    public String getKey() {
        return key;
    }
}


