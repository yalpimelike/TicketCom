package com.melikesivrikaya.indexservice.controller;

import com.melikesivrikaya.indexservice.converter.TripConverter;
import com.melikesivrikaya.indexservice.model.Trip;
import com.melikesivrikaya.indexservice.model.TripDocument;
import com.melikesivrikaya.indexservice.repository.TripDocumentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/v1/index")
@RequiredArgsConstructor
@Slf4j
public class IndexController {

    private final TripDocumentRepository tripDocumentRepository;

    @GetMapping
    public List<Trip> getAll(){

        log.info("Get all trips");

//        Iterable<TripDocument> tripDocuments = tripDocumentRepository.findAll();
//        return StreamSupport.stream(tripDocuments.spliterator(), false)
//                .map(TripConverter::toEnttiy)
//                .collect(Collectors.toList());
        return null;
    }
}
