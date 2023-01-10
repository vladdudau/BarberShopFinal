package com.unibuc.project.barbershop.model;


import javax.persistence.*;
import java.util.List;


import javax.validation.constraints.Pattern;
import javax.validation.constraints.NotBlank;

import static com.unibuc.project.barbershop.model.Pattern.RO_phone_number;

@Entity
public class Barber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;



    @OneToMany(mappedBy = "barber")
    private List<WorkSchedule> workSchedules;


    @OneToMany(mappedBy = "barber")
    private List<Appointment> appointments;

    @Enumerated(EnumType.STRING)
    private Gender gender;


    @NotBlank
    @Pattern(regexp = RO_phone_number)
    private String phoneNumber;

    private Integer seatNumber;

    public long getId() {
        return id;
    }

    public Barber() {
    }


    public Barber(String name, List<WorkSchedule> workSchedules, Gender gender, String phoneNumber, Integer seatNumber) {
        this.name = name;
        this.workSchedules = workSchedules;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.seatNumber = seatNumber;
    }

    public Barber(long id, String name, List<WorkSchedule> workSchedules, Gender gender, String phoneNumber, Integer seatNumber) {
        this.id = id;
        this.name = name;
        this.workSchedules = workSchedules;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.seatNumber = seatNumber;
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

    public List<WorkSchedule> getWorkSchedules() {
        return workSchedules;
    }

    public void setWorkSchedules(List<WorkSchedule> workSchedules) {
        this.workSchedules = workSchedules;
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

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }
}
