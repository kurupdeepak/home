package com.kurup.cainerscrapper.constants;

import com.fasterxml.jackson.datatype.jsr310.deser.key.ZoneIdKeyDeserializer;

public enum ZodiacSign {
    ARIES("ARIES"),
    TAURUS("TAURUS"),
    GEMINI("GEMINI"),
    CANCER("CANCER"),
    LEO("LEO"),
    VIRGO("VIRGO"),
    LIBRA("LIBRA"),
    SCORPIO("SCORPIO"),
    SAGGITTARIUS("SAGGITTARIUS"),
    CAPRICORN("CAPRICORN"),
    AQUARIUS("AQUARIUS"),
    PISCES("PISCES");

    private String name;
    ZodiacSign(String n){
        this.name = n;
    }

}
