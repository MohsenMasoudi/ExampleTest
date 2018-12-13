package com.example.mohsen.exampletest.mvp_example;

public interface LifeCycle <M,V>{

    public void onCreate(M model,V view);

    public void onResume();
    public void onDestroy();
}
