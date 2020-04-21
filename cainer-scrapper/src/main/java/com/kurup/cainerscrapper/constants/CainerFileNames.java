package com.kurup.cainerscrapper.constants;

public enum CainerFileNames {
    ARIES("ariest.html"),
    TAURUS("taurust.html"),
    GEMINI("geminit.html"),
    CANCER("cancert.html"),
    LEO("leot.html"),
    VIRGO("virgot.html"),
    LIBRA("librat.html"),
    SCORPIO("scorpiot.html"),
    SAGGITTARIUS("sagitt.html"),
    CAPRICORN("caprict.html"),
    AQUARIUS("aquariut.html"),
    PISCES("piscest.html"),
    BASE_URL("https://www.cainer.com/daily-horoscope/");

    private String uri;

    CainerFileNames(String n){
        this.uri = n;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
