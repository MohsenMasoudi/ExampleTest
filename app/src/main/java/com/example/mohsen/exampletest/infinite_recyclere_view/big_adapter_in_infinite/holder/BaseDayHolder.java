package com.example.mohsen.exampletest.infinite_recyclere_view.big_adapter_in_infinite.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.mohsen.exampletest.infinite_recyclere_view.big_adapter_in_infinite.presenter.BasePresenter;

public class BaseDayHolder<P extends BasePresenter> extends RecyclerView.ViewHolder {
    public P presenter;

    public BaseDayHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void unBindPresenter() {
        presenter.unBindView();
    }

    public void bindPresenter(P presenter) {
        this.presenter = presenter;
        presenter.bindView(this);
    }
}
