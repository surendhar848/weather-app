package com.example.weather.controller;

import com.example.weather.model.WeatherResponse;
import com.example.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService service;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/weather")
    public String getWeather(@RequestParam("city") String city, Model model) {
        city = city.trim();

        try {
            if (city.isEmpty()) {
                model.addAttribute("error", "Please enter a city name");
                return "index";
            }

            WeatherResponse weather = service.getWeather(city);

            System.out.println("Weather for " + city + ": " + weather.getTemperature() + "°C, " + weather.getDescription());

            model.addAttribute("weather", weather);
            model.addAttribute("city", city);

        } catch (Exception e) {
            System.err.println("Error in WeatherController:");
            e.printStackTrace();
            model.addAttribute("weather", null);
            model.addAttribute("error", "Unable to fetch weather at this time");
        }

        return "index";
    }
}