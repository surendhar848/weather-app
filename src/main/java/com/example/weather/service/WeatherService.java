package com.example.weather.service;

import com.example.weather.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    public WeatherResponse getWeather(String city) {
        WeatherResponse weather = new WeatherResponse();

        try {
            String url = "https://api.openweathermap.org/data/2.5/weather?q="
                    + city + "&appid=" + apiKey + "&units=metric";

            System.out.println("Request URL: " + url);

            RestTemplate restTemplate = new RestTemplate();
            Map<String, Object> response = restTemplate.getForObject(url, Map.class);

            System.out.println("API Response: " + response);

            if (response != null && response.get("main") != null && response.get("weather") != null) {
                Map<String, Object> main = (Map<String, Object>) response.get("main");
                List<Map<String, Object>> weatherList = (List<Map<String, Object>>) response.get("weather");
                Map<String, Object> wind = (Map<String, Object>) response.get("wind");

                weather.setTemperature(Double.parseDouble(main.get("temp").toString()));
                weather.setHumidity(Integer.parseInt(main.get("humidity").toString()));
                weather.setDescription(weatherList.get(0).get("description").toString());
                weather.setIcon(weatherList.get(0).get("icon").toString());
                weather.setWindSpeed(Double.parseDouble(wind.get("speed").toString()));

            } else {
                weather.setTemperature(0);
                weather.setDescription("City not found or API error");
                weather.setHumidity(0);
                weather.setWindSpeed(0);
                weather.setIcon("01d");
                System.err.println("Invalid response structure");
            }

        } catch (Exception e) {
            weather.setTemperature(0);
            weather.setDescription("Error fetching data");
            weather.setHumidity(0);
            weather.setWindSpeed(0);
            weather.setIcon("01d");
            System.err.println("Error in WeatherService:");
            e.printStackTrace();
        }

        return weather;
    }
}