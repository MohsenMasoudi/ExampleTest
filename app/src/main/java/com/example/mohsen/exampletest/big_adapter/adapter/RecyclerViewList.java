package com.example.mohsen.exampletest.big_adapter.adapter;

import com.example.mohsen.exampletest.big_adapter.holder.BaseHolder;
import com.example.mohsen.exampletest.big_adapter.presenter.BasePresenter;

import java.util.ArrayList;
import java.util.List;

public abstract class RecyclerViewList<M, P extends BasePresenter, VH extends BaseHolder<P>>
        extends RecyclerViewAdapter<M, P, VH> {
    protected List<M> list;

    public RecyclerViewList() {
        this.list = new ArrayList<>();
    }

    @Override
    protected M getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
