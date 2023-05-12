package com.sample.weather;

public class Weather {
    String cityName;
    double temperature;
    double humidity;

    public Weather(String name, double temperature, double humidity) {
        this.cityName = name;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public String getcityName() {
        return cityName;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }
}
