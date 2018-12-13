package com.example.mohsen.exampletest.mvp_example;

import com.example.mohsen.exampletest.connection.model.weather_model_xml.Day;

import java.util.List;

public class PresenterMVPExample extends BasePresenterMVPExample<Contains.Model, Contains.View> implements
        LifeCycle<Contains.Model, Contains.View>, Contains.Model.OnFinishedRequest {

    /**
     *  FirstContract we should bindView then setModel
     * @param model
     * @param view
     */
    @Override
    public void onCreate(Contains.Model model, Contains.View view) {
        bindView(view);
        setModel(model);
        updateView();
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {
        unBindView();
    }

    @Override
    public void updateView() {
        if(model!=null) {
            model.getData(this);
        }
    }

    /**
     * Here We cant use view like model because  it is weakReference
     * so we use getView() method instead of view
     */

    @Override
    public void onSuccess(List<Day> list) {
        getView().showWeatherList(list);

    }

    @Override
    public void onError() {
    }
}
