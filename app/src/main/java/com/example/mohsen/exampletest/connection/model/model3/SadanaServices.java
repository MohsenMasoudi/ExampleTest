
package com.example.mohsen.exampletest.connection.model.model3;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class SadanaServices {

    @SerializedName("weather-service")
    private WeatherService mWeatherService;

    public WeatherService getWeatherService() {
        return mWeatherService;
    }

    public void setWeatherService(WeatherService weatherService) {
        mWeatherService = weatherService;
    }

}
