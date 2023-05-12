package com.sample.weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MyAPIService {
    @GET("weather")
    Call<WeatherData> getCurrentWeather(@Query("q") String city, @Query("appid") String apiKey);
}
