package com.example.mohsen.exampletest.mvp_example;


import java.lang.ref.WeakReference;

public abstract class BasePresenterMVPExample<M, V> {
    /**
     * protected This if for the classes that extend BasePresenterMVPExample
     * private is because we want to have weak memory and garbage collector can clean it faster
     */
    protected M model;
    private WeakReference<V> view;


    public void setModel(M model) {
        this.model = model;
        if (isBaseSetUp()) {
            updateView();
        }

    }

    public abstract void updateView();


    public void bindView(V view) {
        this.view = new WeakReference<>(view);
        if (isBaseSetUp()) {
            updateView();
        }
    }

    public void unBindView() {
        this.view = null;
    }

    public V getView() {
        if (view == null) {
            return null;
        } else {
            return view.get();
        }
    }

    private boolean isBaseSetUp() {
        return model != null && getView() != null;
    }

}
