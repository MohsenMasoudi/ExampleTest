package com.example.mohsen.exampletest.big_adapter.adapter;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mohsen.exampletest.R;
import com.example.mohsen.exampletest.big_adapter.holder.DayHolder;
import com.example.mohsen.exampletest.big_adapter.model.Day;
import com.example.mohsen.exampletest.big_adapter.presenter.HolderAdapterPresenter;
import com.example.mohsen.exampletest.big_adapter.presenter.HolderPresenter;
import com.example.mohsen.exampletest.big_adapter.view.HolderView;

public class RecyclerViewDay extends RecyclerViewList<Day, HolderAdapterPresenter,DayHolder> {
    @Override
    protected Object getIdModel(Day day) {
        return day.getId();
    }

    @Override
    protected HolderAdapterPresenter createPresenter(Day day) {
        HolderAdapterPresenter holderAdapterPresenter=new HolderAdapterPresenter();
        holderAdapterPresenter.setModel(day);
        return holderAdapterPresenter;
    }


    @Override
    protected Object getModelId(Day day) {
        return day.getId();
    }

    @NonNull
    @Override
    public DayHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater= LayoutInflater.from(viewGroup.getContext());
        View view=inflater.inflate(R.layout.big_adapter_day_item,viewGroup,false);
        return new DayHolder(view);
    }
}
