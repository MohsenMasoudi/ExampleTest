package com.example.mohsen.exampletest.connection.retrofit;

import com.example.mohsen.exampletest.connection.config.WeatherConfig;
import com.example.mohsen.exampletest.connection.model.weather_model_json.Weather;
import com.example.mohsen.exampletest.connection.model.weather_model_xml.WeatherRoot;

import java.lang.annotation.Retention;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Url;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

public interface RetrofitApiService {

    @GET
    @Json
    Call<Weather> getWeather(@Url String url, @Header(WeatherConfig.AUTHORIZATION_NAME) String authKey);

    @GET()
    @Xml
    Call<WeatherRoot> getWeatherXml(@Url String url);
}

@Retention(RUNTIME)
@interface Xml {
}

@Retention(RUNTIME)
@interface Json {
}
