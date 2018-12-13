package com.example.mohsen.exampletest.mvp_example;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.mohsen.exampletest.R;
import com.example.mohsen.exampletest.connection.model.weather_model_xml.Day;

import java.util.List;

public class ViewMVPExample extends FrameLayout implements Contains.View {
    private Button btn;
    private Context context;
private RecyclerView recyclerView;
    public ViewMVPExample(@NonNull Context context) {
        super(context);
        this.context=context;
        View view = LayoutInflater.from(context).inflate(R.layout.mpv_example_activity, this);
        btn = view.findViewWithTag("btn_big_adapter");
        recyclerView=view.findViewWithTag("recycler_view_big_adapter");

    }



    @Override
    public void showWeatherList(List<Day> days) {
        Log.d("big", "showWeatherList: "+days);
        Toast.makeText(context, "showWeatherList"+days.size(), Toast.LENGTH_SHORT).show();
    }
}
