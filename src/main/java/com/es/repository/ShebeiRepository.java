package com.es.repository;

import com.es.entity.Shebei;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ShebeiRepository extends ElasticsearchRepository<Shebei,String> {
}
