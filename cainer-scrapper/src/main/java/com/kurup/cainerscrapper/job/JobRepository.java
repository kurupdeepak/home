package com.kurup.cainerscrapper.job;

import com.kurup.cainerscrapper.model.Job;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobRepository extends MongoRepository<Job,String> {

}
