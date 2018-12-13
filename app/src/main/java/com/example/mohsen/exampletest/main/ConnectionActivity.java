package com.example.mohsen.exampletest.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.mohsen.exampletest.R;
import com.example.mohsen.exampletest.connection.retrofit.RetrofitConnectionToJsonApiActivity;
import com.example.mohsen.exampletest.connection.retrofit.RetrofitConnectionToXmlApiActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ConnectionActivity extends AppCompatActivity {
    @BindView(R.id.btn_retrofit_connection_activity)
    Button btnRetrofit;
    @BindView(R.id.btn_retrofit2_connection_activity)
    Button btnRetrofit2;

    public static Intent newIntent(Context context) {
        return new Intent(context, ConnectionActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connection_activity);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_retrofit_connection_activity, R.id.btn_retrofit2_connection_activity})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_retrofit_connection_activity:
                startActivity(RetrofitConnectionToJsonApiActivity.newIntent(this));
                break;
            case R.id.btn_retrofit2_connection_activity:
                startActivity(RetrofitConnectionToXmlApiActivity.newIntent(this));
                break;
        }
    }
}
