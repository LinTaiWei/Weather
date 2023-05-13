package com.sample.weather;

public class Weather {
    final String cityName;
    final double temperature;
    final double humidity;

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
