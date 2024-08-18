package com.melikesivrikaya.ticketservice.model;


import com.melikesivrikaya.ticketservice.model.enums.TripType;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Entity
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

    // TODO bunu sefer oluşturulurken type na göre setle
    private int yolcuKapasite;

    @Enumerated(EnumType.STRING)
    private TripType tripType;

    public void setStartDate(String startDate) {
        this.startDate = dateParse(startDate);
    }
    public void setEndDate(String endDate) {
        this.endDate = dateParse(endDate);
    }

    // TODO buradan çıkan hatayı yakala
    public LocalDate dateParse(String date) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        LocalDate localDateNow = LocalDate.now();
        if (localDate.isBefore(localDateNow)){
            throw new RuntimeException("Date is not in the past");
        }
        return localDate;
    }
}
