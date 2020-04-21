package com.kurup.cainerscrapper.model;

import com.kurup.cainerscrapper.constants.ZodiacSign;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
public class Forecast {
    private ZodiacSign zodiacSign;

    private String forecastId;

    private LocalDate dateRecorded;

    private String forecastDetails;

    public ZodiacSign getZodiacSign() {
        return zodiacSign;
    }

    public void setZodiacSign(ZodiacSign zodiacSign) {
        this.zodiacSign = zodiacSign;
    }

    public LocalDate getDateRecorded() {
        return dateRecorded;
    }

    public void setDateRecorded(LocalDate dateRecorded) {
        this.dateRecorded = dateRecorded;
    }

    public String getForecastDetails() {
        return forecastDetails;
    }

    public void setForecastDetails(String forecastDetails) {
        this.forecastDetails = forecastDetails;
    }

    public String getForecastId() {
        return forecastId;
    }

    public void setForecastId(String forecastId) {
        this.forecastId = forecastId;
    }
}
