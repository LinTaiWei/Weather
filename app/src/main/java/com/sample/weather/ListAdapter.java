package com.sample.weather;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ItemViewHolder> {

    ArrayList<Weather> items = new ArrayList<>();

    public ListAdapter() {
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.weather_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.onBind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Weather person) {
        items.add(person);
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView cityNameTextView, temperatureTextView, humidityTextView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            cityNameTextView = itemView.findViewById(R.id.cityNameTextView);
            temperatureTextView = itemView.findViewById(R.id.temperatureTextView);
            humidityTextView = itemView.findViewById(R.id.humidityTextView);
        }

        public void onBind(Weather weather) {
            cityNameTextView.setText(weather.getcityName());

            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            String temperature = "溫度：" + decimalFormat.format(weather.getTemperature()) + " °C";
            String humidity = "濕度：" + decimalFormat.format(weather.getHumidity()) + " %";

            temperatureTextView.setText(temperature);
            humidityTextView.setText(humidity);
        }
    }
}
