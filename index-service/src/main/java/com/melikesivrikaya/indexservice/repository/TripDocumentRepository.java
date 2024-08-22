package com.melikesivrikaya.indexservice.repository;

import com.melikesivrikaya.indexservice.model.TripDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TripDocumentRepository extends ElasticsearchRepository<TripDocument, String> {
}
