package com.example.mohsen.exampletest.infinite_recyclere_view.big_adapter_in_infinite;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mohsen.exampletest.R;
import com.example.mohsen.exampletest.infinite_recyclere_view.InfiniteRecyclerView;
import com.example.mohsen.exampletest.infinite_recyclere_view.big_adapter_in_infinite.adapter.RecyclerViewDayAdapter;
import com.example.mohsen.exampletest.infinite_recyclere_view.big_adapter_in_infinite.model.Day;
import com.example.mohsen.exampletest.infinite_recyclere_view.big_adapter_in_infinite.presenter.Presenter;
import com.example.mohsen.exampletest.infinite_recyclere_view.big_adapter_in_infinite.view.BigAdapterView;

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
    InfiniteRecyclerView recyclerView;
    RecyclerViewDayAdapter adapter;
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
        /**
         * This will excite when items arrives to visibleThreshold that we set that 6
         */
        int i=0;
        recyclerView.setListener(() -> {
            recyclerView.setIsLoading(false);

            Log.d("adapter_2", "onCreate: "+(i+1));
        });
        adapter = new RecyclerViewDayAdapter();

    }

    @Override
    public void showDays(List<Day> dayList) {
        adapter.addAll(dayList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showEmpty() {
        Toast.makeText(this, "Noting to show", Toast.LENGTH_SHORT).show();
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
