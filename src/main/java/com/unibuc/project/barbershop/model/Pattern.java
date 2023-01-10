package com.unibuc.project.barbershop.model;

import java.text.SimpleDateFormat;

public class Pattern {

    public static final String HH_MM_timer = "^4[0-9]{12}(?:[0-9]{3})?$";
    public static final String RO_phone_number = "^(?=0[723][2-8]\\d{7})(?!.*(.)\1{2,}).{10}$";

    public static final String date_format = 	"dd/MM/yyyy";
    public static final SimpleDateFormat formatter = new SimpleDateFormat(date_format);

}