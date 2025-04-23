package com.dobval.open_info_hub.models;

import java.util.List;
import lombok.Data;

@Data
public class WeatherForecast {
    private Daily daily;

    @Data
    public static class Daily {
        private List<String> time;
        private List<Double> temperature_2m_max;
    }
}
