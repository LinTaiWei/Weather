package com.sample.weather;

import com.google.gson.annotations.SerializedName;

public class WeatherData {
    @SerializedName("name")
    private String cityName;

    @SerializedName("main")
    private WeatherInfo weatherInfo;

    public String getCityName() {
        return cityName;
    }

    public WeatherInfo getWeatherInfo() {
        return weatherInfo;
    }

    public static class WeatherInfo {
        @SerializedName("temp")
        private double temperature;

        @SerializedName("humidity")
        private double humidity;

        public double getTemperature() {
            return temperature;
        }

        public double getHumidity() {
            return humidity;
        }
    }
}