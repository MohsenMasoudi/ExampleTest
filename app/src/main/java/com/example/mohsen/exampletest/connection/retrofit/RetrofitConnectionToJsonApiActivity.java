package com.example.mohsen.exampletest.connection.retrofit;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.example.mohsen.exampletest.SingletonActivity;

public class RetrofitConnectionToJsonApiActivity extends SingletonActivity {
    public static Intent newIntent(Context context) {
        return new Intent(context, RetrofitConnectionToJsonApiActivity.class);
    }

    @Override
    public Fragment setFragment() {
        return RetrofitConnectionToJsonApiFragment.newInstance();
    }


}
