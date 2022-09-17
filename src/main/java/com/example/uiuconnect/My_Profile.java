package com.example.uiuconnect;

import java.io.Serializable;

public  class My_Profile implements  Serializable {
    public String ID, name, Password, Mail, Phone,dob, Blood, Department, Batch;

    public My_Profile(String name, String ID, String Password, String Mail, String Phone, String dob,String Blood, String Department, String Batch) {
        this.name = name;
        this.ID = ID;
        this.Password = Password;
        this.Mail = Mail;
        this.Phone = Phone;
        this.dob = dob;
        this.Blood = Blood;
        this.Department = Department;
        this.Batch = Batch;
    }

    public String getBatch() {
        return Batch;
    }

    public My_Profile(String name, String Password, String Mail, String Phone,String dob, String Blood) {
        this.name = name;
        this.Password = Password;
        this.Mail = Mail;
        this.Phone = Phone;
        this.dob = dob;
        this.Blood = Blood;
    }

    public String getDepartment() {return Department;}

    public String getPhone() {return Phone;}

    public String getDob() {return dob;}

    public String getBlood() {return Blood;}

    public String getMail() {return Mail;}

    public String getPassword() {return Password;}

    public String getID() {return ID;}

    public String getName() {return name;}

    //public String getDob() {return dob;}
}