
package com.example.mohsen.exampletest.connection.model.weather_model_xml;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "sadana-services",strict = false)
public class SadanaServices {

    @Element(name = "weather-service",required = false)
    private WeatherService mWeatherService;

    public WeatherService getWeatherService() {
        return mWeatherService;
    }

    public void setWeatherService(WeatherService weatherService) {
        mWeatherService = weatherService;
    }

}
