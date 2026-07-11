public class WeatherService {
    private ExternalWeatherApi weatherApi;
    
    public WeatherService(ExternalWeatherApi weatherApi) {
        this.weatherApi = weatherApi;
    }
    
    public String getWeatherReport(String city) {
        String weather = weatherApi.getWeather(city);
        return "Weather in " + city + ": " + weather;
    }
    
    public boolean isHotDay(String city, double threshold) {
        double temp = weatherApi.getTemperature(city);
        return temp > threshold;
    }
}