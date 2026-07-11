import static org.mockito.Mockito.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class WeatherServiceTest {
    
    @Test
    public void testMockingAndStubbing() {
        ExternalWeatherApi mockApi = mock(ExternalWeatherApi.class);
        
        when(mockApi.getWeather("Delhi"))
            .thenReturn("Sunny");
        
        when(mockApi.getTemperature("Delhi"))
            .thenReturn(42.5);
        
        WeatherService service = new WeatherService(mockApi);
        
        String report = service.getWeatherReport("Delhi");
        assertEquals("Weather in Delhi: Sunny", report);
        
        assertTrue(service.isHotDay("Delhi", 40.0));
    }
    
    @Test
    public void testMultipleStubs() {
        ExternalWeatherApi mockApi = mock(ExternalWeatherApi.class);
        
        when(mockApi.getWeather("Delhi"))
            .thenReturn("Hot & Sunny");
        
        when(mockApi.getWeather("Bangalore"))
            .thenReturn("Cool & Cloudy");
        
        when(mockApi.getTemperature("Delhi"))
            .thenReturn(45.0);
        
        when(mockApi.getTemperature("Bangalore"))
            .thenReturn(28.0);
        
        WeatherService service = new WeatherService(mockApi);
        
        assertEquals("Weather in Delhi: Hot & Sunny", 
                     service.getWeatherReport("Delhi"));
        assertEquals("Weather in Bangalore: Cool & Cloudy", 
                     service.getWeatherReport("Bangalore"));
        
        assertTrue(service.isHotDay("Delhi", 40.0));
        assertFalse(service.isHotDay("Bangalore", 30.0));
    }
    
    @Test
    public void testExceptionStubbing() {
        ExternalWeatherApi mockApi = mock(ExternalWeatherApi.class);
        
        when(mockApi.getTemperature("UnknownCity"))
            .thenThrow(new IllegalArgumentException("City not found"));
        
        WeatherService service = new WeatherService(mockApi);
        
        try {
            service.isHotDay("UnknownCity", 30.0);
            fail("Should throw exception");
        } catch (IllegalArgumentException e) {
            assertEquals("City not found", e.getMessage());
        }
    }
}