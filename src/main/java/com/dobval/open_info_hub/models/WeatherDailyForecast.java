package com.dobval.open_info_hub.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// For representing the weather in a chart 
// (only WeatherForecast.java is raw JSON)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherDailyForecast {
	private String date;
	private double maxTemp;
}
