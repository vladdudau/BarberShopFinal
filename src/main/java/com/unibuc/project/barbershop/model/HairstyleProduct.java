package com.unibuc.project.barbershop.model;


import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class HairstyleProduct {

    @ManyToMany
    @JoinTable(name="appointments_products",
    joinColumns =@JoinColumn(name="appointment_id"),
    inverseJoinColumns =@JoinColumn(name="product_id"))
    private List<Appointment> appointments;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String name;

    private double purchasePrice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public HairstyleProduct() {
    }

    public HairstyleProduct(long id, String name, double purchasePrice) {
        this.id = id;
        this.name = name;
        this.purchasePrice = purchasePrice;
    }

    public HairstyleProduct(String name, double purchasePrice) {
        this.name = name;
        this.purchasePrice = purchasePrice;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public long getId() {
        return id;
    }
}
