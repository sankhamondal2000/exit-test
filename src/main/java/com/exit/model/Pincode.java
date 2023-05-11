package com.exit.model;

import javax.persistence.Entity;
import javax.persistence.Id;


/*
    This class will create a pincode table in database with two field
 */
@Entity
public class Pincode {

    @Id
    private Long pincode;
    private String days;

    public Pincode() {
    }

    public Pincode(Long pincode, String  days) {
        this.pincode = pincode;
        this.days = days;
    }

    public Long getPincode() {
        return pincode;
    }

    public void setPincode(Long pincode) {
        this.pincode = pincode;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }
}
