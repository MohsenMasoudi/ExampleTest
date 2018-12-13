package com.example.mohsen.exampletest.data_base.greendao_data_base;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mohsen.exampletest.App;
import com.example.mohsen.exampletest.R;
import com.example.mohsen.exampletest.data_base.greendao_data_base.model.DaoSession;
import com.example.mohsen.exampletest.data_base.greendao_data_base.model.School;
import com.example.mohsen.exampletest.data_base.greendao_data_base.model.SchoolDao;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class GDAddSchoolFragment extends DialogFragment {
    @BindView(R.id.edit_txt_add_school_name_fragment)
    EditText editTxtAddSchoolName;
    @BindView(R.id.edit_txt_add_school_manager_fragment)
    EditText editTxtAddSchoolManager;
    @BindView(R.id.btn_add_school_fragment)
    Button btnAddSchool;
    Unbinder unbinder;
    private SchoolDao schoolDao;


    public GDAddSchoolFragment() {
        // Required empty public constructor
    }

    public static GDAddSchoolFragment newInstance() {
        Bundle args = new Bundle();
        GDAddSchoolFragment fragment = new GDAddSchoolFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.data_base_add_school_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        editTxtAddSchoolManager.setVisibility(View.GONE);
        getDB();
        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    void getDB() {
        DaoSession daoSession = ((App) Objects.requireNonNull(getActivity()).getApplication()).getGreenDaoSession();
        schoolDao = daoSession.getSchoolDao();
    }
    @OnClick(R.id.btn_add_school_fragment)
    public void onViewClicked() {
        setDataToDB();
        dismiss();
    }


    void setDataToDB() {
        School school = new School();
        if (editTxtAddSchoolName.getText() != null
                && !editTxtAddSchoolName.getText().toString().equals("")) {
            school.setName(editTxtAddSchoolName.getText().toString());
            schoolDao.insert(school);
        } else {
            Toast.makeText(getActivity(), "Enter School Name", Toast.LENGTH_SHORT).show();
        }
    }

}
