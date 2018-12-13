package com.example.mohsen.exampletest.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.mohsen.exampletest.R;
import com.example.mohsen.exampletest.view.custom_view.TypeOneCustomView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestCustomViewActivity extends AppCompatActivity {
    public static Intent getNewIntent(Context context) {
        return new Intent(context, TestCustomViewActivity.class);
    }
    @BindView(R.id.type_one_custom_view)
    TypeOneCustomView typeOneCustomView;
    @BindView(R.id.btn_swap_color)
    Button btnSwapColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_view_test_activity);
        ButterKnife.bind(this);
//        typeOneCustomView=new TypeOneCustomView(this);
    }

    @OnClick(R.id.btn_swap_color)
    public void onViewClicked() {
        typeOneCustomView.swapColor();
    }
}
