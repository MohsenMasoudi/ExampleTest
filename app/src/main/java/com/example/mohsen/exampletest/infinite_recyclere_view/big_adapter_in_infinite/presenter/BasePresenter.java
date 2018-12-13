package com.example.mohsen.exampletest.infinite_recyclere_view.big_adapter_in_infinite.presenter;


import java.lang.ref.WeakReference;

public abstract class BasePresenter<V, M> {
    /**
     * protected This if for the classes that extend BasePresenterMVPExample
     * private is because we want to have weak memory and garbage collector can clean it faster
     */
    protected M model;
    private WeakReference<V> view;


    public void setModel(M model) {
        this.model = model;
        if (isBaseBind()) {
            updateView();
        }

    }

    public abstract void updateView();


    public void bindView(V view) {
        this.view = new WeakReference<>(view);
        if (isBaseBind()) {
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

    private boolean isBaseBind() {
        return model != null && getView() != null;
    }

}
