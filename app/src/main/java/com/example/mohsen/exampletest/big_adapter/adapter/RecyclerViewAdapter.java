package com.example.mohsen.exampletest.big_adapter.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.example.mohsen.exampletest.big_adapter.holder.BaseHolder;
import com.example.mohsen.exampletest.big_adapter.presenter.BasePresenter;

import java.util.HashMap;
import java.util.Map;

public abstract class RecyclerViewAdapter<M, P extends BasePresenter, VH extends BaseHolder>
        extends RecyclerView.Adapter<VH> {
    protected Map<Object, P> presenters;

    public RecyclerViewAdapter() {
        this.presenters = new HashMap<>();
    }

    public P getPresenter(M m) {
        return presenters.get(getIdModel(m));
    }

    protected abstract Object getIdModel(M m);

    @Override
    public boolean onFailedToRecycleView(@NonNull VH holder) {
        holder.unBindPresenter();
        return super.onFailedToRecycleView(holder);
    }

    @Override
    public void onViewRecycled(@NonNull VH holder) {
        super.onViewRecycled(holder);
        holder.unBindPresenter();
    }

    /**
     * @param vh
     * @param i  position
     */
    @Override
    public void onBindViewHolder(@NonNull VH vh, int i) {
//        vh.bindPresenter(createPresenter(getItem(i)));
        vh.bindPresenter(getPresenter(getItem(i )));
    }

    protected abstract P createPresenter(M m);

    protected abstract Object getModelId(M m);

    protected abstract M getItem(int position);

}
