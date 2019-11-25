package com.kurup.cainerscrapper;

import com.kurup.cainerscrapper.job.ForecastJobScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CainerScrapperApplication {//implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CainerScrapperApplication.class, args);
    }
}
