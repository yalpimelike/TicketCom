package com.melikesivrikaya.searchservice.controller;

import com.melikesivrikaya.searchservice.model.TripDocument;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/search")
@RequiredArgsConstructor
public class SearchController {

    private final ElasticsearchOperations elasticsearchOperations;

    @GetMapping("/startCity")
    public List<TripDocument> searchByStartCity(@RequestParam String startCity){
        QueryBuilder queryBuilder = QueryBuilders.matchQuery("startCity", startCity);

        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(queryBuilder).build();

        List<SearchHit<TripDocument>> productHits = elasticsearchOperations.search(searchQuery, TripDocument.class,
                IndexCoordinates.of("trip")).getSearchHits();
        return productHits.stream().map(SearchHit::getContent).collect(Collectors.toList());
    }

    @GetMapping("/endCity")
    public List<TripDocument> searchByEndCity(@RequestParam String endCity){
        QueryBuilder queryBuilder = QueryBuilders.matchQuery("endCity", endCity);

        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(queryBuilder).build();

        List<SearchHit<TripDocument>> productHits = elasticsearchOperations.search(searchQuery, TripDocument.class,
                IndexCoordinates.of("trip")).getSearchHits();
        return productHits.stream().map(SearchHit::getContent).collect(Collectors.toList());
    }

    @GetMapping("/tripType")
    public List<TripDocument> searchByTripType(@RequestParam String tripType){
        QueryBuilder queryBuilder = QueryBuilders.matchQuery("tripType", tripType);

        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(queryBuilder).build();

        List<SearchHit<TripDocument>> productHits = elasticsearchOperations.search(searchQuery, TripDocument.class,
                IndexCoordinates.of("trip")).getSearchHits();
        return productHits.stream().map(SearchHit::getContent).collect(Collectors.toList());
    }

    @GetMapping("/startDate")
    public List<TripDocument> searchByStartDate(@RequestParam String startDate){
        QueryBuilder queryBuilder = QueryBuilders.matchQuery("startDate", startDate);

        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(queryBuilder).build();

        List<SearchHit<TripDocument>> productHits = elasticsearchOperations.search(searchQuery, TripDocument.class,
                IndexCoordinates.of("trip")).getSearchHits();
        return productHits.stream().map(SearchHit::getContent).collect(Collectors.toList());
    }

    @GetMapping("/endDate")
    public List<TripDocument> searchByEndDate(@RequestParam String endDate){
        QueryBuilder queryBuilder = QueryBuilders.matchQuery("endDate", endDate);

        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(queryBuilder).build();

        List<SearchHit<TripDocument>> productHits = elasticsearchOperations.search(searchQuery, TripDocument.class,
                IndexCoordinates.of("trip")).getSearchHits();
        return productHits.stream().map(SearchHit::getContent).collect(Collectors.toList());
    }

}
