package com.example.mohsen.exampletest.big_adapter.presenter;

import com.example.mohsen.exampletest.big_adapter.model.Day;
import com.example.mohsen.exampletest.big_adapter.view.BigAdapterView;

import java.util.List;

public class Presenter extends BasePresenter<BigAdapterView, List<Day>> {

    @Override
    public void updateView() {
        if (model.size() == 0) {
            getView().showEmpty();
        } else {
            getView().showDays(model);
        }

    }

    public void addDay() {
        Day day = new Day();
        day.setName("1");
        day.setMax(5);
        day.setMin(-3);
        model.add(day);
        updateView();
    }
}
