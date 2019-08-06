package com.parser;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.parse.models.LocationWraper;
import com.parse.models.Wrapper;

@Repository
public interface DataRepostiroy extends ReactiveMongoRepository<Wrapper, Long> {

}
