package com.example.project.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table
public class Donation {
    @Id
    private String idDonation;
    private int numPayment;
    private int option;
    private Date date;
    private String phone;
    private double sum;

    public Donation(String idDonation, int numPayment, int option, Date date, String phone, double sum) {
        this.idDonation = idDonation;
        this.numPayment = numPayment;
        this.option = option;
        this.date = date;
        this.phone = phone;
        this.sum = sum;
    }
    public Donation() {
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public int getNumPayment() {
        return numPayment;
    }

    public void setNumPayment(int numPayment) {
        this.numPayment = numPayment;
    }

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIdDonation() {
        return idDonation;
    }

    public void setIdDonation(String idDonation) {
        this.idDonation = idDonation;
    }

    @Override
    public String toString() {
        return "donation{" +
                "idDonation='" + idDonation + '\'' +
                ", numPayment=" + numPayment +
                ", option=" + option +
                ", date=" + date +
                ", phone='" + phone + '\'' +
                ", sum=" + sum +
                '}';
    }
}
