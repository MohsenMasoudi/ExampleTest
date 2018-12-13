package com.example.mohsen.exampletest.infinite_recyclere_view;

import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import lombok.Setter;

public abstract class ShowEndListScroll extends InfiniteRecyclerView.OnScrollListener {
    private static final int THRESHOLD = 3;
    private int totalItemCount, lastVisibleItem;
    private int previousItemCount = 0;

    /**
     * This shows us that recyclerView is scrolling down
     */
    @Setter
    private boolean isLoading;
    private RecyclerView.LayoutManager layoutManager;

    public ShowEndListScroll(RecyclerView.LayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }

    /**
     * Constructor doesn't have any accessibility to anything
     */
//    public ShowEndListScroll() {
//        super();
//    }
    @Override
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
    }

    @Override
    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {


        totalItemCount = layoutManager.getItemCount();
        /**
         * if you want that only nce at the end get load more method not every time just skip this if
         */
        if (lastVisibleItem < totalItemCount-2) {
            previousItemCount = 0;
            Log.d("what is happening", "onScrolled: ");
        }
        if (layoutManager instanceof GridLayoutManager){
            lastVisibleItem = ((GridLayoutManager)layoutManager).findLastVisibleItemPosition();
        }else if (layoutManager instanceof LinearLayoutManager){
            lastVisibleItem = ((LinearLayoutManager)layoutManager).findLastVisibleItemPosition();
        }else if (layoutManager instanceof StaggeredGridLayoutManager){
            StaggeredGridLayoutManager staggeredGridLayoutManager=(StaggeredGridLayoutManager) layoutManager;
            int spanCount=staggeredGridLayoutManager.getSpanCount();
            int[] ids=new int[spanCount];
            staggeredGridLayoutManager.findLastVisibleItemPositions(ids);
            int max=ids[0];
            for (int i = 1; i < ids.length; i++) {
                if (ids[1]>max){
                    max=ids[1];
                }
            }
            lastVisibleItem=max;
        }
        if (totalItemCount > THRESHOLD) {
            if (previousItemCount <= totalItemCount && isLoading) {
                isLoading = false;
                Log.i("InfiniteScroll", "Data fetched"+isLoading);
            }
            Log.d("InfiniteScrol", "total=" + totalItemCount +
                    "\n last_visible=" + lastVisibleItem +
                    "\n previousItemCount=" + previousItemCount+"\n"+isLoading);
            if (!isLoading && (lastVisibleItem > (totalItemCount - THRESHOLD)) && totalItemCount > previousItemCount) {
                onMoreLoad();

                Log.i("InfiniteScroll", "End Of List"+isLoading);
                isLoading = true;
                previousItemCount = totalItemCount;
            }

        }
        super.onScrolled(recyclerView, dx, dy);


    }

    abstract void onMoreLoad();
}
