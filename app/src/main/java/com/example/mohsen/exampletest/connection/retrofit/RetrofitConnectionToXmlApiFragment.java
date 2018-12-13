package com.example.mohsen.exampletest.connection.retrofit;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mohsen.exampletest.R;
import com.example.mohsen.exampletest.connection.config.WeatherConfig;
import com.example.mohsen.exampletest.connection.model.weather_model_xml.Day;
import com.example.mohsen.exampletest.connection.model.weather_model_xml.WeatherRoot;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RetrofitConnectionToXmlApiFragment extends Fragment {


    @BindView(R.id.recycler_view_connection_rerofit_fragment)
    RecyclerView recycler;
    Unbinder unbinder;
    private ObjectAdapter adapter;

    public RetrofitConnectionToXmlApiFragment() {
    }

    public static RetrofitConnectionToXmlApiFragment newInstance() {
        RetrofitConnectionToXmlApiFragment fragment = new RetrofitConnectionToXmlApiFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.connection_retrofit_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        getApi();
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void getApi() {
        RetrofitApiClient retrofitApiClient=new RetrofitApiClient();
        RetrofitApiService apiService = retrofitApiClient
                .getRetrofit(WeatherConfig.PARSIJOO_XML_URL)
                .create(RetrofitApiService.class);
        Call<WeatherRoot> result = apiService.getWeatherXml("api?serviceType=weather-API&q=شیراز");
        result.enqueue(new Callback<WeatherRoot>() {
            @Override
            public void onResponse(Call<WeatherRoot> call, Response<WeatherRoot> response) {
                if (response.isSuccessful()) {
                    try {
                        List<Day> days= Objects.requireNonNull(response.body()).getSadanaServices().getWeatherService().getDayList();
                        setRecyclerView(days);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<WeatherRoot> call, Throwable t) {
                Toast.makeText(getActivity(), "fail", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void setRecyclerView(List<Day> days) {
        adapter = new ObjectAdapter(days);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler.setAdapter(adapter);
    }

    private class ObjectHolder extends RecyclerView.ViewHolder {
        private CheckedTextView mCheckedTextViewMax;
        private CheckedTextView mCheckedTextViewMin;
        private TextView mTxtTemp;
        private TextView mTextViewCondition;
        private TextView mTxtViewCityName;
        private TextView mTextViewDayName;
        private ImageView mImageViewSymbol;


        public ObjectHolder(@NonNull View itemView) {
            super(itemView);
            mCheckedTextViewMax = itemView.findViewById(R.id.checkedTextView_max_weather_item_list_xml_api);
            mCheckedTextViewMin = itemView.findViewById(R.id.checkedTextView_min_weather_item_list_xml_api);
            mTxtTemp = itemView.findViewById(R.id.txt_temp_weather_item_list_xml_api);
            mTextViewCondition = itemView.findViewById(R.id.textView_condition_weather_item_list_xml_api);
            mTxtViewCityName = itemView.findViewById(R.id.txt_view_city_name_weather_item_list_xml_api);
            mTextViewDayName = itemView.findViewById(R.id.textView_dayName_weather_item_list_xml_api);
            mImageViewSymbol = itemView.findViewById(R.id.imageView_symbol_weather_item_list_xml_api);
        }

        public void bindUI(Day day) {
            if (day.getmCityName() == null) {
                mTextViewCondition.setVisibility(View.GONE);
                mTxtViewCityName.setVisibility(View.GONE);
                mTxtTemp.setVisibility(View.GONE);
            } else {
                mTextViewCondition.setText(day.getmStatus());
                mTxtViewCityName.setText(day.getmCityName());
                mTxtTemp.setText(String.format("%s :%s", getString(R.string.now_temp), day.getmTemp()));
            }
            mCheckedTextViewMax.setText(day.getmMaxTemp());
            mCheckedTextViewMin.setText(day.getmMinTemp());
            mTextViewDayName.setText(day.getmDayName());
            String url = String.format(getString(R.string.get_day_pic), day.getmSymbol());
            Picasso.get().load(url).into(mImageViewSymbol);

        }
    }

    private class ObjectAdapter extends RecyclerView.Adapter<ObjectHolder> {
        List<Day> days;

        public ObjectAdapter(List<Day> days) {
            this.days = days;
        }

        @NonNull
        @Override
        public ObjectHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view = inflater.inflate(R.layout.weather_item_list_xml_api, viewGroup, false);
            return new ObjectHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ObjectHolder objectHolder, int i) {
            Day day = days.get(i);
            objectHolder.bindUI(day);
        }

        @Override
        public int getItemCount() {
            return days.size();
        }
    }
}
