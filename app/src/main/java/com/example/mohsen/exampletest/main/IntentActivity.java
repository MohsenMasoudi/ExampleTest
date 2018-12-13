package com.example.mohsen.exampletest.main;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.mohsen.exampletest.R;
import com.example.mohsen.exampletest.intent.ImplicitActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;




public class IntentActivity extends AppCompatActivity {
    @BindView(R.id.btn_implicit_intent_activity)
    Button btnImplicitIntentActivity;

    public static Intent newIntent(Context context) {
        return new Intent(context, IntentActivity.class);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_activity);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_implicit_intent_activity)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_implicit_intent_activity:
                startActivity(ImplicitActivity.newIntent(this));
                break;
        }
    }



}
