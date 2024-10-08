package com.melikesivrikaya.tripservice.model;

import com.melikesivrikaya.tripservice.exception.ExceptionMessages;
import com.melikesivrikaya.tripservice.exception.TripException;
import com.melikesivrikaya.tripservice.model.enums.TripType;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Entity
@Setter
@Table(name = "trips")
@AllArgsConstructor
@NoArgsConstructor
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String startCity;
    private String endCity;
    private LocalDate startDate;
    private LocalDate endDate;
    private int price;

    private int travelerCount;


    @Enumerated(EnumType.STRING)
    private TripType tripType;

    public void setStartDate(String startDate) {
        this.startDate = dateParse(startDate);
    }
    public void setEndDate(String endDate) {
        this.endDate = dateParse(endDate);
    }


    public LocalDate dateParse(String date) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        LocalDate localDateNow = LocalDate.now();
        if (localDate.isBefore(localDateNow)){
            throw new TripException(ExceptionMessages.INVALID_DATE);
        }
        return localDate;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", startCity='" + startCity + '\'' +
                ", endCity='" + endCity + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", price=" + price +
                ", travelerCount=" + travelerCount +
                ", tripType=" + tripType +
                '}';
    }
}
