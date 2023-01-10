package com.unibuc.project.barbershop.model;


import javax.persistence.*;

import static com.unibuc.project.barbershop.model.Pattern.RO_phone_number;

@Entity
public class Customer {

    @OneToOne
    @JoinColumn(name="appointment_id")
    Appointment appointment;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private Gender gender;

    private String phoneNumber;

    public long getId() {
        return id;
    }

    public Customer(String name, Gender gender, String phoneNumber) {
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }



    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Customer() {
    }

    public Customer(long id, String name, Gender gender, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }
}
