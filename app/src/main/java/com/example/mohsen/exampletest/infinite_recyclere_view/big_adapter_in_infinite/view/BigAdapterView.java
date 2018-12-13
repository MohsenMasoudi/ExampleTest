package com.example.mohsen.exampletest.infinite_recyclere_view.big_adapter_in_infinite.view;

import com.example.mohsen.exampletest.infinite_recyclere_view.big_adapter_in_infinite.model.Day;

import java.util.List;

public interface BigAdapterView {
    void showDays(List<Day> dayList);

    void showEmpty();
}
