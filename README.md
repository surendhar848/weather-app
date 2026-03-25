# weather-app
Weather App
Overview

This is a simple Weather Monitoring Web Application built using Java Spring Boot and Thymeleaf.
It allows users to enter a city name and fetch the current weather information, including temperature, weather description, humidity, wind speed, and weather icon.

The app uses the OpenWeatherMap API to get real-time weather data.

Technologies Used
Language: Java 17
Framework: Spring Boot 3.x
Template Engine: Thymeleaf
Build Tool: Maven
Frontend: HTML, CSS (with Google Fonts and responsive design)
API: OpenWeatherMap (for current weather data)
Features
Search for the weather in any city.
Displays:
Temperature (°C)
Weather description (e.g., few clouds, sunny)
Humidity (%)
Wind speed (m/s)
Weather icon
Handles invalid city names and API errors gracefully.
Responsive and animated UI with a cloud/weather background.
Uses MVC architecture:
Controller: Handles user input and communicates with the service layer.
Service: Fetches weather data from OpenWeatherMap API and parses it.
Model: Stores structured weather information.
View: Displays weather information to the user using Thymeleaf templates.
Prerequisites
Java 17 or higher installed
Maven installed
Internet connection (for API requests)
OpenWeatherMap API key
Setup Instructions
Clone the repository or download the project.
Open the project in your preferred IDE (IntelliJ IDEA, Eclipse, VS Code).

Add your OpenWeatherMap API key in application.properties:

weather.api.key=YOUR_API_KEY_HERE

Build the project with Maven:

mvn clean install

Run the Spring Boot application:

mvn spring-boot:run

Open your browser and go to:

http://localhost:8080/
Project Structure
weather-app/
│
├─ src/main/java/com/example/weather/
│   ├─ controller/       -> Handles web requests (WeatherController.java)
│   ├─ model/            -> Stores weather data (WeatherResponse.java)
│   ├─ service/          -> Calls API and processes data (WeatherService.java)
│   └─ WeatherApplication.java -> Main Spring Boot application
│
├─ src/main/resources/
│   ├─ templates/        -> Thymeleaf HTML templates (index.html)
│   └─ application.properties -> API key and configuration
│
├─ pom.xml              -> Maven dependencies
Notes
Make sure your API key is active in OpenWeatherMap.
If the API key is invalid, the app will show an error message.
The UI is animated and responsive with a cloud/weather background for a better user experience.
License

This project is for educational and personal use.
