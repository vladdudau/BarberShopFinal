package com.unibuc.project.barbershop.model;


import javax.persistence.*;
import java.util.List;
@Entity
public class WorkSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Barber barber;


    @Enumerated(EnumType.STRING)
    private Workday workday;

    private String startTime;

    private String endTime;

    public Barber getBarber() {
        return barber;
    }

    public WorkSchedule() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setBarber(Barber barber) {
        this.barber = barber;
    }

    public Workday getWorkday() {
        return workday;
    }

    public void setWorkday(Workday workday) {
        this.workday = workday;
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

    public WorkSchedule(Workday workday, String startTime, String endTime) {

        this.workday = workday;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public WorkSchedule(long id, Barber barber, Workday workday, String startTime, String endTime) {
        this.id = id;
        this.barber = barber;
        this.workday = workday;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public WorkSchedule(Barber barber, Workday workday, String startTime, String endTime) {
        this.barber = barber;
        this.workday = workday;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public WorkSchedule(long id, Workday workday, String startTime, String endTime) {
        this.id = id;
        this.workday = workday;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
