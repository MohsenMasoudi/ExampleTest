package com.example.mohsen.exampletest.big_adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mohsen.exampletest.R;
import com.example.mohsen.exampletest.big_adapter.model.Day;
import com.example.mohsen.exampletest.big_adapter.presenter.Presenter;
import com.example.mohsen.exampletest.big_adapter.view.BigAdapterView;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BigAdapterViewActivity extends AppCompatActivity implements BigAdapterView {
    @BindView(R.id.btn_big_adapter)
    Button btn;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private Presenter presenter;

    @NotNull
    @Contract("_ -> new")
    public static Intent newIntent(Context context) {
        return new Intent(context, BigAdapterViewActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.big_adapter_activity);
        ButterKnife.bind(this);
        presenter = new Presenter();
        presenter.setModel(new ArrayList<>());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void showDays(List<Day> dayList) {
        Toast.makeText(this, dayList.size() + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showEmpty() {
        Toast.makeText(this, "Yes", Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.btn_big_adapter})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_big_adapter:
                presenter.addDay();
                break;

        }
    }

    @OnClick(R.id.btn_big_adapter)
    public void onViewClicked() {
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (presenter == null) {
            presenter = new Presenter();
        }
        presenter.bindView(this);

    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.unBindView();
    }

}
