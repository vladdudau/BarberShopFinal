package com.unibuc.project.barbershop.model;


import javax.persistence.*;
import java.util.List;

import static com.unibuc.project.barbershop.model.Pattern.HH_MM_timer;

@Entity
public class WorkSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Barber barber;

    @ElementCollection(targetClass = Workday.class)
    @JoinTable(name = "workdays", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "workdays", nullable = false)
    @Enumerated(EnumType.STRING)
    private List<Workday> workdays;

    private String startTime;

    private String endTime;

    public Barber getBarber() {
        return barber;
    }

    public WorkSchedule() {
    }

    public WorkSchedule(long id, Barber barber, List<Workday> workdays, String startTime, String endTime) {
        this.id = id;
        this.barber = barber;
        this.workdays = workdays;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public WorkSchedule(Barber barber, List<Workday> workdays, String startTime, String endTime) {
        this.barber = barber;
        this.workdays = workdays;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void setBarber(Barber barber) {
        this.barber = barber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public List<Workday> getWorkdays() {
        return workdays;
    }

    public void setWorkdays(List<Workday> workdays) {
        this.workdays = workdays;
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
}
