package com.foodDeliverySystem.fooddelivery.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.sql.Date;
import java.time.DayOfWeek;

@Entity
public class Staff {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private DayOfWeek dayOfOperations;
    private Long contactNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DayOfWeek getDayOfOperations() {
        return dayOfOperations;
    }

    public void setDayOfOperations(DayOfWeek dayOfOperations) {
        this.dayOfOperations = dayOfOperations;
    }

    public Long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Long contactNumber) {
        this.contactNumber = contactNumber;
    }
}