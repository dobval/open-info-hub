package com.dobval.open_info_hub.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocodingApiResult {
    private String lat;
    private String lon;
}
