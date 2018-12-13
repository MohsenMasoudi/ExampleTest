package com.example.mohsen.exampletest.connection.retrofit;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mohsen.exampletest.R;
import com.example.mohsen.exampletest.connection.config.WeatherConfig;
import com.example.mohsen.exampletest.connection.model.weather_model_json.DayList;
import com.example.mohsen.exampletest.connection.model.weather_model_json.Weather;
import com.github.pwittchen.weathericonview.WeatherIconView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class RetrofitConnectionToJsonApiFragment extends Fragment {
    @BindView(R.id.recycler_view_connection_rerofit_fragment)
    RecyclerView recyclerView;
    Unbinder unbinder;
    private ObjectAdapter adapter;

    public RetrofitConnectionToJsonApiFragment() {
        // Required empty public constructor
    }

    public static RetrofitConnectionToJsonApiFragment newInstance() {

        Bundle args = new Bundle();

        RetrofitConnectionToJsonApiFragment fragment = new RetrofitConnectionToJsonApiFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.connection_retrofit_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        checkApi();

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.recycler_view_connection_rerofit_fragment)
    public void onViewClicked() {
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.retrofit_connection_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.weather_item_retrofit_connection_menu:
                Toast.makeText(getActivity(), "working", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);

    }

    void checkApi() {
        RetrofitApiClient retrofitApiClient = new RetrofitApiClient();
        RetrofitApiService apiInterface = retrofitApiClient
                .getRetrofit(WeatherConfig.PARSIJOO_URL)
                .create(RetrofitApiService.class);
        Call<Weather> apiResult = apiInterface.getWeather("web-service/v1/weather/?type=search&city=%D8%B4%DB%8C%D8%B1%D8%A7%D8%B2", WeatherConfig.AUTHORIZATION_CODE);
        apiResult.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(@NotNull Call<Weather> call, @NotNull Response<Weather> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    setAdapter(response.body().getResult().getHava().getDayList());
                }
                Toast.makeText(getActivity(), response.code() + "", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {

            }
        });
    }

    private void setAdapter(List<DayList> dayListList) {
        adapter = new ObjectAdapter((ArrayList<DayList>) dayListList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private class ObjectHolder extends RecyclerView.ViewHolder {
        public WeatherIconView mImageViewSymbol;
        private CheckedTextView mCheckedTextViewMax;
        private CheckedTextView mCheckedTextViewMin;
        private TextView mTextViewCondition;
        private TextView mTextViewDayName;
        private WeatherIconView weatherIconView;


        public ObjectHolder(@NonNull View itemView) {
            super(itemView);
            mCheckedTextViewMax = itemView.findViewById(R.id.checkedTextView_max_weather_item_list_layout);
            mCheckedTextViewMin = itemView.findViewById(R.id.checkedTextView_min_weather_item_list_layout);
            mTextViewCondition = itemView.findViewById(R.id.textView_condition_weather_item_list_layout);
            mTextViewDayName = itemView.findViewById(R.id.textView_dayName_weather_item_list_layout);
            weatherIconView = itemView.findViewById(R.id.imageView_symbol_weather_item_list_layout);

        }

        public void bindUI(DayList dayList) {
            mCheckedTextViewMax.setText(String.format(" %s", dayList.getMax()));
            mCheckedTextViewMin.setText(String.format(" %s", dayList.getMin()));
            weatherIconView.setIconResource(getStringResourceByName(dayList.getSymbol()));
            weatherIconView.setIconSize(40);
            mTextViewDayName.setText(" " + dayList.getName());
            mTextViewCondition.setText(dayList.getCondition());

        }

        private String getStringResourceByName(String aString) {
            String s;
            s = aString.replace("-", "_");
            String packageName = Objects.requireNonNull(getActivity()).getPackageName();
            int resId = getResources().getIdentifier(s, "string", packageName);
            return getString(resId);
        }
    }

    private class ObjectAdapter extends RecyclerView.Adapter<ObjectHolder> {
        ArrayList<DayList> dayListArrayList;

        public ObjectAdapter(ArrayList<DayList> dayListArrayList) {
            this.dayListArrayList = dayListArrayList;
        }

        @NonNull
        @Override
        public ObjectHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view = inflater.inflate(R.layout.weather_item_list_layout, viewGroup, false);
            return new ObjectHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ObjectHolder objectHolder, int i) {
            DayList dayList = dayListArrayList.get(i);
            objectHolder.bindUI(dayList);
        }

        @Override
        public int getItemCount() {
            return dayListArrayList.size();
        }
    }
}
