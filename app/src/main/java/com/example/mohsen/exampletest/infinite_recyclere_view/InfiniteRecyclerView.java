package com.example.mohsen.exampletest.infinite_recyclere_view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import lombok.Setter;

public class InfiniteRecyclerView extends RecyclerView {
    @Setter
    private OnLoadMoreListener listener;
    private ShowEndListScroll showEndListScroll;

    public InfiniteRecyclerView(@NonNull Context context) {
        super(context);
    }

    public InfiniteRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public InfiniteRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setIsLoading(boolean setIsLoading) {
        showEndListScroll.setLoading(setIsLoading);
    }

    @Override
    public void setLayoutManager(@Nullable LayoutManager layout) {
        if (!(layout instanceof LinearLayoutManager)) {
            throw new RuntimeException("Layout Should be Linear");
        }
        showEndListScroll = new ShowEndListScroll(layout) {
            @Override
            void onMoreLoad() {
                if (listener != null) {
                    listener.onLoad();
                }
            }
        };
//        showEndListScroll.setLoading(setIsLoading);
        addOnScrollListener(showEndListScroll);
        super.setLayoutManager(layout);

    }

}
