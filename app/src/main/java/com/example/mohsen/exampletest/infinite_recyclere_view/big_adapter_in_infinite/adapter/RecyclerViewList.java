package com.example.mohsen.exampletest.infinite_recyclere_view.big_adapter_in_infinite.adapter;

import com.example.mohsen.exampletest.infinite_recyclere_view.big_adapter_in_infinite.holder.DayHolder;
import com.example.mohsen.exampletest.infinite_recyclere_view.big_adapter_in_infinite.presenter.HolderPresenter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class RecyclerViewList<M, P extends HolderPresenter, VH extends DayHolder> extends RecyclerViewAdapter<M, P, VH> {
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

    public void addAll(Collection<M> data) {
        for (M item : data) {
            addInternal(item);
        }

        int addedSize = data.size();
        int oldSize = list.size() - addedSize;
        notifyItemRangeInserted(oldSize, addedSize);
    }
    private void addInternal(M m) {
        System.err.println("Adding item " + getIdModel(m));
       list.add(m);
        presenters.put(getModelId(m), createPresenter(m));
    }
}
