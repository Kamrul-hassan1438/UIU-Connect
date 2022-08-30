package com.example.uiuconnect;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.*;

public  class My_Profile implements  Serializable {
    public String ID, name, Password, Mail, Phone, Blood, Department, Batch;

    public My_Profile(String name, String ID, String Password, String Mail, String Phone, String Blood, String Department, String Batch) {
        this.name = name;
        this.ID = ID;
        this.Password = Password;
        this.Mail = Mail;
        this.Phone = Phone;
        this.Blood = Blood;
        this.Department = Department;
        this.Batch = Batch;
    }

    public String getBatch() {
        return Batch;
    }

    public My_Profile(String name, String Password, String Mail, String Phone, String Blood) {
        this.name = name;
        this.Password = Password;
        this.Mail = Mail;
        this.Phone = Phone;
        this.Blood = Blood;
    }

    public String getDepartment() {
        return Department;
    }

    public String getPhone() {
        return Phone;
    }

    public String getBlood() {
        return Blood;
    }

    public String getMail() {
        return Mail;
    }

    public String getPassword() {
        return Password;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

}