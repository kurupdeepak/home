package com.kurup.cainerscrapper.job;

import com.kurup.cainerscrapper.ForecastRepository;
import com.kurup.cainerscrapper.constants.CainerFileNames;
import com.kurup.cainerscrapper.constants.ZodiacSign;
import com.kurup.cainerscrapper.model.Forecast;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.Stream;

@Component
public class ForecastJobScheduler {
    private static Logger log = LoggerFactory.getLogger(ForecastJobScheduler.class);

    private static final int CONTENT_INDEX = 8;

    private  static String baseURL;

    @Autowired
    private ForecastRepository forecastRepository;

    @Autowired
    private JobRepository jobRepository;


    @Scheduled(fixedDelay = 5 * 60 * 60 * 1000)
    public void run(){
        long s = System.currentTimeMillis();
        log.info("Going to start the job " + LocalDateTime.now());
        Stream.of(ZodiacSign.values())
                .map((z) -> {  return fetchContent(z);    })
                .forEach((f) -> this.forecastRepository.save(f));
        log.info("Job completed  " + (System.currentTimeMillis() - s) + " ms ");
    }

   private static Forecast fetchContent(ZodiacSign zs){
        Forecast forecast = new Forecast();
        log.info("Fetch information for " + zs);
        try {
            Document doc = Jsoup.connect(CainerFileNames.valueOf("BASE_URL").getUri() + CainerFileNames.valueOf(zs.name()).getUri()).get();
            forecast.setZodiacSign(zs);
            forecast.setDateRecorded(LocalDate.now());
            forecast.setForecastDetails(doc.getElementsByTag("table").get(CONTENT_INDEX).text());
        } catch (IOException e) {
            e.printStackTrace();
            forecast.setForecastDetails("Job failed for " + zs.name() + " " + e.getMessage());
            log.error("Fetch information failed for  " + zs + " , error " + forecast.getForecastDetails());
        }
        return forecast;
    }


    public String getBaseURL() {
        return baseURL;
    }

    @Value("${forecast.reader.base-url}")
    public void setBaseURL(String baseURL) {
        ForecastJobScheduler.baseURL = baseURL;
    }
}
