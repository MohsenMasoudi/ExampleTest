package com.example.mohsen.exampletest.data_base.greendao_data_base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mohsen.exampletest.App;
import com.example.mohsen.exampletest.R;
import com.example.mohsen.exampletest.data_base.greendao_data_base.model.DaoSession;
import com.example.mohsen.exampletest.data_base.greendao_data_base.model.School;
import com.example.mohsen.exampletest.data_base.greendao_data_base.model.SchoolDao;

import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class GDShowSchoolListFragment extends Fragment {
    @BindView(R.id.show_list_fragment_recycler_view)
    RecyclerView showListFragmentRecyclerView;
    Unbinder unbinder;
    private SchoolAdapter schoolAdapter;
    private ArrayList<School> schools;
    private SchoolDao schoolDao;

    public static GDShowSchoolListFragment newInstance() {

        Bundle args = new Bundle();

        GDShowSchoolListFragment fragment = new GDShowSchoolListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.recycler_view_layout, container, false);
        unbinder = ButterKnife.bind(this, view);
        getDB();
        setRecyclerView();
        return view;
    }

    void getDB() {
        DaoSession daoSession = ((App) Objects.requireNonNull(getActivity()).getApplication()).getGreenDaoSession();
        schoolDao = daoSession.getSchoolDao();
    }

    void setRecyclerView() {
        schoolAdapter = new SchoolAdapter((ArrayList<School>) schoolDao.loadAll());
        showListFragmentRecyclerView.setAdapter(schoolAdapter);
        showListFragmentRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private class SchoolHolder extends RecyclerView.ViewHolder {
        private TextView mTxtName;
        private TextView mTxtId;
        private TextView mTxtManager;
        private TextView mTxtStudentNumber;
        private TextView mTxtTeachersNumber;

        public SchoolHolder(@NonNull View itemView) {
            super(itemView);

            mTxtName = itemView.findViewById(R.id.txt_name_data_base_school_item_for_recycler_view);
            mTxtId = itemView.findViewById(R.id.txt_id_data_base_school_item_for_recycler_view);
            mTxtManager = itemView.findViewById(R.id.txt_manager_data_base_school_item_for_recycler_view);
            mTxtStudentNumber = itemView.findViewById(R.id.txt_student_number_data_base_school_item_for_recycler_view);
            mTxtTeachersNumber = itemView.findViewById(R.id.txt_teachers_number_data_base_school_item_for_recycler_view);

        }

        public void bindUI(School school) {
            mTxtName.setText(String.format("School Name:%s", school.getName()));
            mTxtId.setText(String.format("School Id:%d ", school.getId()));
            try {
                mTxtManager.setText(String.format("Manager Name:%s", school.getManager().getLastName()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                mTxtStudentNumber.setText(String.format("Students Number:%d", school.getStudents().size()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                mTxtTeachersNumber.setText(String.format("Teachers Number %d", school.getTeachers().size()));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    private class SchoolAdapter extends RecyclerView.Adapter<SchoolHolder> {
        private ArrayList<School> schools;

        public SchoolAdapter(ArrayList<School> schools) {
            this.schools = schools;
        }

        @NonNull
        @Override
        public SchoolHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.data_base_school_list_item, viewGroup, false);
            return new SchoolHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull SchoolHolder schoolHolder, int i) {
            School school = schools.get(i);
            schoolHolder.bindUI(school);

        }

        @Override
        public int getItemCount() {
            return schools.size();
        }

    }
}
