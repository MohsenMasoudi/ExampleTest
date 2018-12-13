package com.example.mohsen.exampletest.infinite_recyclere_view.big_adapter_in_infinite.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.example.mohsen.exampletest.infinite_recyclere_view.big_adapter_in_infinite.holder.DayHolder;
import com.example.mohsen.exampletest.infinite_recyclere_view.big_adapter_in_infinite.presenter.HolderPresenter;

import java.util.HashMap;
import java.util.Map;

public abstract class RecyclerViewAdapter<M, P extends HolderPresenter, VH extends DayHolder>
        extends RecyclerView.Adapter<VH> {
    protected final   HashMap<Object, Object> presenters;
    protected Map<Object, P> presenter;
    public RecyclerViewAdapter() {

            presenters = new HashMap<>();

    }

    @NonNull protected abstract Object getModelId(@NonNull M model);

    public P getPresenter(M m) {
        return presenter.get(getIdModel(m));
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
        vh.bindPresenter(createPresenter(getItem(i)));
    }

    protected abstract P createPresenter(M m);

    protected abstract M getItem(int position);

}
