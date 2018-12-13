package com.example.mohsen.exampletest.big_adapter.presenter;

import com.example.mohsen.exampletest.big_adapter.model.Day;
import com.example.mohsen.exampletest.big_adapter.view.HolderView;

public class HolderPresenter extends BasePresenter<HolderView, Day> {
    @Override
    public void updateView() {
        if (model != null) {
            getView().bindItem(model);
        }

    }

    public void addTolist(Day day) {
        setModel(day);

    }


}
