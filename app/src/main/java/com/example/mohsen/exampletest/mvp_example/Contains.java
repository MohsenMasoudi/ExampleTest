package com.example.mohsen.exampletest.mvp_example;

import com.example.mohsen.exampletest.connection.model.weather_model_xml.Day;

import java.util.List;

public class Contains {
    interface View {
        void showWeatherList(List<Day> weatherList);
    }

    interface Model {
        interface OnFinishedRequest {
            void onSuccess(List<Day> name);
            void  onError();
        }
        void getData(OnFinishedRequest request);
    }
}
