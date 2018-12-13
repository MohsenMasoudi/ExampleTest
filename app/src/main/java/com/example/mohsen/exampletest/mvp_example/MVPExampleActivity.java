package com.example.mohsen.exampletest.mvp_example;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class MVPExampleActivity extends AppCompatActivity {
    PresenterMVPExample presenter;

    public static Intent newIntent(Context context) {
        return new Intent(context, MVPExampleActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ModelMVPExample model = new ModelMVPExample(this);
        ViewMVPExample view = new ViewMVPExample(this);
        setContentView(view);
        presenter = new PresenterMVPExample();
        presenter.onCreate(model, view);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
