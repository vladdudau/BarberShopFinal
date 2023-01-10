package com.unibuc.project.barbershop.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


import javax.validation.constraints.Pattern;

import static com.unibuc.project.barbershop.model.Pattern.HH_MM_timer;
import static com.unibuc.project.barbershop.model.Pattern.date_format;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(mappedBy = "appointment")
    private Customer customer;

    @OneToOne(mappedBy = "appointment")
    private Barber barber;

    private boolean isCancelled = false;

    @Enumerated(EnumType.STRING)
    @Column(name="payment_type")
    private PaymentType paymentType;


    @JsonFormat(pattern = date_format)
    LocalDate date;


    @Pattern(regexp = HH_MM_timer)
    private String startTime;


    @Pattern(regexp = HH_MM_timer)
    private String endTime;

    @ManyToMany(mappedBy = "appointments")
    private List<HairstyleProduct> products;

    public Appointment(long id, Customer customer, Barber barber, boolean isCancelled, PaymentType paymentType, LocalDate date, String startTime, String endTime, List<HairstyleProduct> products) {
        this.id = id;
        this.customer = customer;
        this.barber = barber;
        this.isCancelled = isCancelled;
        this.paymentType = paymentType;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.products = products;
    }

    public Appointment(Customer customer, Barber barber, boolean isCancelled, PaymentType paymentType, LocalDate date, String startTime, String endTime, List<HairstyleProduct> products) {
        this.customer = customer;
        this.barber = barber;
        this.isCancelled = isCancelled;
        this.paymentType = paymentType;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.products = products;
    }

    public Appointment() {
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Barber getBarber() {
        return barber;
    }

    public void setBarber(Barber barber) {
        this.barber = barber;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public List<HairstyleProduct> getProducts() {
        return products;
    }

    public void setProducts(List<HairstyleProduct> products) {
        this.products = products;
    }
}
