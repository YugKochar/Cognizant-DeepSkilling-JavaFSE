public interface ExternalWeatherApi {
    String getWeather(String city);
    double getTemperature(String city);
}