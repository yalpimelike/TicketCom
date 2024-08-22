package com.melikesivrikaya.searchservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "trip")
public class TripDocument {

    @Id
    private String id;
    private String startCity;
    private String endCity;
    private String startDate;
    private String endDate;
    private int price;
    private int occupant;
    private String tripType;
}
