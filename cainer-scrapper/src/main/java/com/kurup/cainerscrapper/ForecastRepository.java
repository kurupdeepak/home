package com.kurup.cainerscrapper;

import com.kurup.cainerscrapper.model.Forecast;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ForecastRepository extends MongoRepository<Forecast,String> {
}
