package com.example.mohsen.exampletest.infinite_recyclere_view.big_adapter_in_infinite.adapter;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mohsen.exampletest.R;
import com.example.mohsen.exampletest.infinite_recyclere_view.big_adapter_in_infinite.holder.DayHolder;
import com.example.mohsen.exampletest.infinite_recyclere_view.big_adapter_in_infinite.model.Day;
import com.example.mohsen.exampletest.infinite_recyclere_view.big_adapter_in_infinite.presenter.HolderPresenter;

public class RecyclerViewDayAdapter extends RecyclerViewList<Day, HolderPresenter, DayHolder> {
    @NonNull
    @Override
    protected Object getModelId(@NonNull Day model) {
        return model.getId();
    }

    @Override
    protected Object getIdModel(Day day) {
        return day.getId();
    }

    @Override
    protected HolderPresenter createPresenter(Day day) {
        HolderPresenter holderPresenter=new HolderPresenter();
        holderPresenter.setModel(day);
        return holderPresenter;
    }

    @NonNull
    @Override
    public DayHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater= LayoutInflater.from(viewGroup.getContext());
        View view=inflater.inflate(R.layout.big_adapter_day_item,viewGroup,false);
        return new DayHolder(view);
    }
}
