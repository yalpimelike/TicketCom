package com.melikesivrikaya.indexservice.controller;

import com.melikesivrikaya.indexservice.model.TripDocument;
import com.melikesivrikaya.indexservice.repository.TripDocumentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/index")
@RequiredArgsConstructor
@Slf4j
public class IndexController {

    private final TripDocumentRepository tripDocumentRepository;

    @GetMapping
    public Iterable<TripDocument> getAll(){
        return tripDocumentRepository.findAll();
    }
}
