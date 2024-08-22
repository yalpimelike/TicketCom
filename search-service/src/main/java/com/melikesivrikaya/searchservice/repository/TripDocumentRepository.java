package com.melikesivrikaya.searchservice.repository;

import com.melikesivrikaya.searchservice.model.TripDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TripDocumentRepository extends ElasticsearchRepository<TripDocument, String> {
}
