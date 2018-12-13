package com.example.mohsen.exampletest.big_adapter.view;

import com.example.mohsen.exampletest.big_adapter.model.Day;

import java.util.List;

public interface BigAdapterView {
    void showDays(List<Day> dayList);

    void showEmpty();
}
