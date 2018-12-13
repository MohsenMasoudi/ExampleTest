package com.example.mohsen.exampletest.mvp_example;

import android.content.Context;

import com.example.mohsen.exampletest.connection.config.WeatherConfig;
import com.example.mohsen.exampletest.connection.model.weather_model_xml.Day;
import com.example.mohsen.exampletest.connection.model.weather_model_xml.WeatherRoot;
import com.example.mohsen.exampletest.connection.retrofit.RetrofitApiClient;
import com.example.mohsen.exampletest.connection.retrofit.RetrofitApiService;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelMVPExample implements Contains.Model{
    private Context context;

    public ModelMVPExample(Context context) {
        this.context = context;
    }



    @Override
    public void getData(OnFinishedRequest request) {
        RetrofitApiClient retrofitApiClient=new RetrofitApiClient();
        RetrofitApiService apiService = retrofitApiClient
                .getRetrofit(WeatherConfig.PARSIJOO_XML_URL)
                .create(RetrofitApiService.class);
        Call<WeatherRoot> result = apiService.getWeatherXml("api?serviceType=weather-API&q=شیراز");
        result.enqueue(new Callback<WeatherRoot>() {
            @Override
            public void onResponse(Call<WeatherRoot> call, Response<WeatherRoot> response) {
                if (response.isSuccessful()) {
                    try {
                        List<Day> days= Objects.requireNonNull(response.body()).getSadanaServices().getWeatherService().getDayList();
                        request.onSuccess(days);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<WeatherRoot> call, Throwable t) {
                request.onError();
            }
        });
    }
}
