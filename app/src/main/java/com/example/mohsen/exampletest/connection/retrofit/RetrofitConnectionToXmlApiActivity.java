package com.example.mohsen.exampletest.connection.retrofit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.example.mohsen.exampletest.SingletonActivity;

public class RetrofitConnectionToXmlApiActivity extends SingletonActivity {
    public static Intent newIntent(Context context) {
        return new Intent(context, RetrofitConnectionToXmlApiActivity.class);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public Fragment setFragment() {
        return RetrofitConnectionToXmlApiFragment.newInstance();
    }
}
