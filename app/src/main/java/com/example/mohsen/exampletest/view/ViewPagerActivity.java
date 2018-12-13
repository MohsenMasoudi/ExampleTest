package com.example.mohsen.exampletest.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.mohsen.exampletest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewPagerActivity extends AppCompatActivity {
    public static Intent getNewIntent(Context context) {
        return new Intent(context, ViewPagerActivity.class);
    }
    @BindView(R.id.view_pager_example)
    ViewPager viewPagerExample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager_activity);
        ButterKnife.bind(this);
        FragmentManager fragmentManager=getSupportFragmentManager();
        viewPagerExample.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int i) {
                return ViewPagerFragment.newInstance(i);
            }

            @Override
            public int getCount() {
                return 10;
            }
        });
    }
}
