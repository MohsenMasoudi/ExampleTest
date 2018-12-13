package com.example.mohsen.exampletest.infinite_recyclere_view.big_adapter_in_infinite.holder;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.example.mohsen.exampletest.R;
import com.example.mohsen.exampletest.infinite_recyclere_view.big_adapter_in_infinite.model.Day;
import com.example.mohsen.exampletest.infinite_recyclere_view.big_adapter_in_infinite.presenter.BasePresenter;
import com.example.mohsen.exampletest.infinite_recyclere_view.big_adapter_in_infinite.view.HolderView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DayHolder extends BaseDayHolder implements HolderView {
    @BindView(R.id.checkedTextView_max_big_adapter_day_item)
    CheckedTextView checkedTextViewMax;
    @BindView(R.id.checkedTextView_min_big_adapter_day_item)
    CheckedTextView checkedTextViewMin;
    @BindView(R.id.textView_dayName_big_adapter_day_item)
    TextView textViewDayName;
    @BindView(R.id.condition_big_adapter_day_item)
    TextView condition;
    private int max;
    private int min;

    public DayHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void unBindPresenter() {
        super.unBindPresenter();
    }

    @Override
    public void bindPresenter(BasePresenter presenter) {
        super.bindPresenter(presenter);
    }

    @Override
    public void bindItem(Day day) {
//        condition.setText(day.getCondition());
        max = day.getMax();
        min = day.getMin();
        checkedTextViewMin.setOnClickListener(v -> min--);
        checkedTextViewMax.setOnClickListener(v -> max++);
        day.setMin(min);
        day.setMax(max);
        condition.setText(String.format(itemView.getContext().getString(R.string.day_item_format), day.getMax(), day.getMin()));

    }
}
//    @OnClick({R.id.checkedTextView_max_big_adapter_day_item,R.id.checkedTextView_min_big_adapter_day_item})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.btn_big_adapter:
//                presenters.addDay();
//                break;
//
//        }