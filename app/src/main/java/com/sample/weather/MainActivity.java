package com.sample.weather;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ListAdapter adapter;
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    private static final String API_KEY = "2cfe1a8d1a71f9ff0e86d0fb1bc55e2d";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.weatherRecyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);

        adapter = new ListAdapter();
        recyclerView.setAdapter(adapter);

        getWeatherList();
    }


    private void getWeatherList() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // 建立 API Service 實例
        MyAPIService myAPIService = retrofit.create(MyAPIService.class);
        String[] cities = {"Taipei", "Taoyuan", "Hsinchu", "Miaoli"};
        // 發送 API 請求
        for (String city : cities) {
            Call<WeatherData> call = myAPIService.getCurrentWeather(city, API_KEY);
            call.enqueue(new Callback<WeatherData>() {
                @SuppressLint("NotifyDataSetChanged")
                @Override
                public void onResponse(@NonNull Call<WeatherData> call, @NonNull Response<WeatherData> response) {
                    if (response.isSuccessful()) {
                        WeatherData weatherData = response.body();
                        assert weatherData != null;
                        double celsius = weatherData.getWeatherInfo().getTemperature() - 273.15;
                        Weather item = new Weather(weatherData.getCityName(), celsius, weatherData.getWeatherInfo().getHumidity());
                        adapter.addItem(item);
                        adapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<WeatherData> call, @NonNull Throwable t) {
                }
            });
        }
    }
}