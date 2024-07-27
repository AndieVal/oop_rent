/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lib;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author ranip
 */
public class RentRecord {
    private Rent rent;
    private String duration;
    private RentStatus status;

   
    public RentRecord(Rent r) {
        this.rent = rent;
        this.duration = formatPeriod(r.getRentalPeriod());
        this.status = LocalDate.now().isBefore(r.getLastDate())
                || LocalDate.now().equals(r.getLastDate()) ? RentStatus.Available : RentStatus.Rented;
    }
    
   
    private String formatPeriod(Period period) {
        StringBuilder formattedPeriod = new StringBuilder();

        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();

        if (years > 0) {
            formattedPeriod.append(years).append(" year");
            if (years > 1) {
                formattedPeriod.append("s");
            }
            if (months > 0 || days > 0) {
                formattedPeriod.append(", ");
            }
        }

        if (months > 0) {
            formattedPeriod.append(months).append(" month");
            if (months > 1) {
                formattedPeriod.append("s");
            }
            if (days > 0) {
                formattedPeriod.append(", ");
            }
        }

        if (days > 0) {
            formattedPeriod.append(days).append(" day");
            if (days > 1) {
                formattedPeriod.append("s");
            }
        }

        return formattedPeriod.toString();
    }
    
    public enum RentStatus {
        Available, Rented
    }

    public Rent getRent() {
        return rent;
    }

    public String getDuration() {
        return duration;
    }

    public RentStatus getStatus() {
        return status;
    }
     
     
}
