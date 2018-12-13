package com.example.mohsen.exampletest.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.mohsen.exampletest.R;
import com.example.mohsen.exampletest.big_adapter.BigAdapterViewActivity;
import com.example.mohsen.exampletest.mvp_example.MVPExampleActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_views)
    Button btnViews;
    @BindView(R.id.btn_internet_connections)
    Button btnInternetConnections;
    @BindView(R.id.btn_dataBase)
    Button btnDataBase;
    @BindView(R.id.btn_intent)
    Button btnIntent;
    @BindView(R.id.btn_big_adapter_activity)
    Button btnConnection;
    @BindView(R.id.btn_mvp_example_activity)
    Button btnBigAdapterMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.btn_views
            , R.id.btn_internet_connections
            , R.id.btn_dataBase
            , R.id.btn_intent
            , R.id.btn_big_adapter_activity
            , R.id.btn_mvp_example_activity})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_views:
                startActivity(ViewActivity.getNewIntent(this));
                break;
            case R.id.btn_internet_connections:
                startActivity(ConnectionActivity.newIntent(this));
                break;
            case R.id.btn_dataBase:
                startActivity(DataBaseActivity.newIntent(this));
                break;
            case R.id.btn_intent:
                startActivity(IntentActivity.newIntent(this));
                break;
            case R.id.btn_big_adapter_activity:
               startActivity( BigAdapterViewActivity.newIntent(this));
                break;
            case R.id.btn_mvp_example_activity:
                startActivity(MVPExampleActivity.newIntent(this));
                break;
        }
    }

}
