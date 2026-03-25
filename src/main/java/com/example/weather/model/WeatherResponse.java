package com.example.weather.model;

public class WeatherResponse {
    private double temperature;
    private String description;
    private int humidity;
    private double windSpeed;
    private String icon;

    // Getters and setters
    public double getTemperature() { return temperature; }
    public void setTemperature(double temperature) { this.temperature = temperature; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getHumidity() { return humidity; }
    public void setHumidity(int humidity) { this.humidity = humidity; }

    public double getWindSpeed() { return windSpeed; }
    public void setWindSpeed(double windSpeed) { this.windSpeed = windSpeed; }

    public String getIcon() { return icon; }
    public void setIcon(String icon) { this.icon = icon; }
}