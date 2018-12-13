package com.example.mohsen.exampletest.big_adapter.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.mohsen.exampletest.big_adapter.presenter.BasePresenter;

public class BaseHolder<P extends BasePresenter> extends RecyclerView.ViewHolder {
    public P presenter;

    public BaseHolder(@NonNull View itemView) {
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
