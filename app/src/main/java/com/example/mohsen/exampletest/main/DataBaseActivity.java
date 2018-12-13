package com.example.mohsen.exampletest.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.mohsen.exampletest.R;
import com.example.mohsen.exampletest.data_base.greendao_data_base.GDActivity;
import com.example.mohsen.exampletest.data_base.simple_sqlite_data_base.SimpleDataBaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DataBaseActivity extends AppCompatActivity {
    @BindView(R.id.btn_simple_data_base)
    Button btnSimpleDataBase;
    @BindView(R.id.btn_green_dao_data_base)
    Button btnGreenDaoDataBase;
    @BindView(R.id.btn_realm_data_base)
    Button btnRealmDataBase;
    @BindView(R.id.btn_sugar_orm_data_base)
    Button btnSugarOrmDataBase;
    @BindView(R.id.btn_room_data_base)
    Button btnRoomDataBase;
    @BindView(R.id.btn_external_data_base)
    Button btnExternalDataBase;

    public static Intent newIntent(Context context) {
        return new Intent(context, DataBaseActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_base_activity);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_simple_data_base, R.id.btn_green_dao_data_base, R.id.btn_realm_data_base, R.id.btn_sugar_orm_data_base, R.id.btn_room_data_base, R.id.btn_external_data_base})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_simple_data_base:
                startActivity(SimpleDataBaseActivity.newIntent(this));
                break;
            case R.id.btn_green_dao_data_base:
                startActivity(GDActivity.newIntent(this));
                break;
            case R.id.btn_realm_data_base:
                break;
            case R.id.btn_sugar_orm_data_base:
                break;
            case R.id.btn_room_data_base:
                break;
            case R.id.btn_external_data_base:
                break;
        }
    }
}
