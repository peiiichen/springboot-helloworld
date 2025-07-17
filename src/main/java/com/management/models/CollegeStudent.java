package com.management.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;


import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class CollegeStudent implements Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;
    @Column
    @Getter
    @Setter
    private String firstname;
    @Column
    @Getter
    @Setter
    private String lastname;
    @Column(name = "email_address")
    @Getter
    @Setter
    private String emailAddress;

    public CollegeStudent() {
    }

    public CollegeStudent(String firstname, String lastname, String emailAddress) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailAddress = emailAddress;
    }

    @Override
    public String getFullName() {
        return getFirstname()+" "+getLastname();
    }

    @Override
    public String toString() {
        return "CollegeStudent{" +
                "id" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                "}";
    }

    public String studentInformation(){ return  getFullName() + " " + getEmailAddress();}

}