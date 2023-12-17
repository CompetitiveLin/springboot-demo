package com.example.demo.repository;

import com.example.demo.mbg.model.SysLog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CanalToElasticsearchRepository extends ElasticsearchRepository<SysLog, String> {

}
