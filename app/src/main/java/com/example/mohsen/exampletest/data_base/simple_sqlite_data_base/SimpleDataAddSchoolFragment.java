package com.example.mohsen.exampletest.data_base.simple_sqlite_data_base;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.mohsen.exampletest.R;
import com.example.mohsen.exampletest.data_base.simple_sqlite_data_base.data_base_lab.SchoolRepository;
import com.example.mohsen.exampletest.data_base.simple_sqlite_data_base.model.School;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleDataAddSchoolFragment extends DialogFragment {


    @BindView(R.id.edit_txt_add_school_name_fragment)
    EditText editTxtAddSchoolNameFragment;
    @BindView(R.id.text_input_layout)
    TextInputLayout textInputLayout;
    @BindView(R.id.edit_txt_add_school_manager_fragment)
    EditText editTxtAddSchoolManagerFragment;
    @BindView(R.id.text_input_layout_2)
    TextInputLayout textInputLayout2;
    @BindView(R.id.btn_add_school_fragment)
    Button btnAddSchool;
    Unbinder unbinder;

    public SimpleDataAddSchoolFragment() {
        // Required empty public constructor
    }

    public static SimpleDataAddSchoolFragment newInstance() {

        Bundle args = new Bundle();
        SimpleDataAddSchoolFragment fragment = new SimpleDataAddSchoolFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.data_base_add_school_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_add_school_fragment)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_add_school_fragment:
                saveData();
                dismiss();
        }
    }

    private void saveData() {
        String manager = editTxtAddSchoolManagerFragment.getText().toString().trim();
        String name = editTxtAddSchoolNameFragment.getText().toString().trim();
        if (!manager.equals("") && !name.equals("")) {
            School school = new School();
            school.setName(name);
            school.setManager(manager);
            SchoolRepository.getInstance(getActivity()).addSchool(school);


        }
    }


}
