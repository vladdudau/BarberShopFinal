package com.unibuc.project.barbershop.dto;

import com.unibuc.project.barbershop.model.Barber;
import com.unibuc.project.barbershop.model.Customer;
import com.unibuc.project.barbershop.model.HairstyleProduct;
import com.unibuc.project.barbershop.model.PaymentType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

import static com.unibuc.project.barbershop.model.Pattern.HH_MM_timer;


@ApiModel(value = "Appointment request", description = "Required details needed to create a new Appointment")
public class AppointmentRequest {

    @NotNull
    @ApiModelProperty(value = "customer", required = true, notes = "Provide all details of customer or just id for lookup", position = 1)
    private Customer customer;

    @NotNull
    @ApiModelProperty(value = "barber", required = true, notes = "Provide all details of barber or just id for lookup", position = 2)
    private Barber barber;

    private boolean isCancelled = false;


    @NotNull
    @ApiModelProperty(value = "paymentType", required = true, notes = "Payment type", example = "debit or cash", position = 3)
    private PaymentType paymentType;

    @NotNull
    @ApiModelProperty(value = "date", required = true, notes = "Calendar date in future", example="07-02-2023", position = 4)
    LocalDate date;

    @NotBlank
    @Pattern(regexp = HH_MM_timer)
    @ApiModelProperty(value = "startTime", required = true, notes = "Appointment start date", example="16:00", position = 5)
    private String startTime;

    @NotBlank
    @Pattern(regexp = HH_MM_timer)
    @ApiModelProperty(value = "endTime", required = true, notes = "Appointment end date", example="17:00", position = 6)
    private String endTime;



    @NotNull
    @ApiModelProperty(value = "products", required = true, notes = "Appointment products to apply", example="All details or id for lookup", position = 7)
    private List<HairstyleProduct> products;

    public AppointmentRequest() {
    }

    public AppointmentRequest(Customer customer, Barber barber, boolean isCancelled, PaymentType paymentType, LocalDate date, String startTime, String endTime, List<HairstyleProduct> products) {
        this.customer = customer;
        this.barber = barber;
        this.isCancelled = isCancelled;
        this.paymentType = paymentType;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.products = products;
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

    public List<HairstyleProduct> getProducts() {
        return products;
    }

    public void setProducts(List<HairstyleProduct> products) {
        this.products = products;
    }
}
