package com.example.mohsen.exampletest.infinite_recyclere_view.big_adapter_in_infinite.presenter;

import com.example.mohsen.exampletest.infinite_recyclere_view.big_adapter_in_infinite.model.Day;
import com.example.mohsen.exampletest.infinite_recyclere_view.big_adapter_in_infinite.view.HolderView;

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
