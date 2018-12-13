package com.example.mohsen.exampletest.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.mohsen.exampletest.R;
import com.example.mohsen.exampletest.view.RecyclerViewActivity;
import com.example.mohsen.exampletest.view.TestCustomViewActivity;
import com.example.mohsen.exampletest.view.ViewPagerActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewActivity extends AppCompatActivity {
    @BindView(R.id.btn_recycler_view)
    Button btnRecyclerView;

    @BindView(R.id.btn_view_pager)
    Button btnViewPager;
    @BindView(R.id.btn_custom_view_test)
    Button btnCustomViewTest;

    public static Intent getNewIntent(Context context) {
        return new Intent(context, ViewActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_activity);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.btn_recycler_view, R.id.btn_view_pager,R.id.btn_custom_view_test})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_recycler_view:
                startActivity(RecyclerViewActivity.getNewIntent(this));
                break;
            case R.id.btn_view_pager:
                startActivity(ViewPagerActivity.getNewIntent(this));
                break;
                case R.id.btn_custom_view_test:
                startActivity(TestCustomViewActivity.getNewIntent(this));
                break;
        }
    }
}
