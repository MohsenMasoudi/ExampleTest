package com.example.mohsen.exampletest.data_base.simple_sqlite_data_base;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mohsen.exampletest.R;
import com.example.mohsen.exampletest.data_base.simple_sqlite_data_base.data_base_lab.SchoolRepository;
import com.example.mohsen.exampletest.data_base.simple_sqlite_data_base.model.School;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleDataShowSchoolListFragment extends Fragment {

    public static SimpleDataShowSchoolListFragment newInstance() {
        
        Bundle args = new Bundle();
        
        SimpleDataShowSchoolListFragment fragment = new SimpleDataShowSchoolListFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @BindView(R.id.show_list_fragment_recycler_view)
    RecyclerView showListFragmentRecyclerView;
    Unbinder unbinder;
    private SchoolAdapter schoolAdapter;
    private ArrayList<School> schools;


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
            mTxtName.setText(school.getName());
            mTxtId.setText(String.format("%d", school.getId()));
            mTxtManager.setText(school.getManager());
//            mTxtStudentNumber.setText(String.format("%d", school.getStudents().size()));
//            mTxtTeachersNumber.setText(String.format("%d", school.getTeachers().size()));

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
            View view = layoutInflater.inflate(R.layout.data_base_school_list_item, viewGroup,false);
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.recycler_view_layout, container, false);
        unbinder = ButterKnife.bind(this, view);
        setAdapter();
        setRecyclerView();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void setAdapter() {
        schools = new ArrayList<>();
        schools = SchoolRepository.getInstance(getActivity()).getSchools();
        schoolAdapter = new SchoolAdapter(schools);
    }
    private void setRecyclerView(){
        showListFragmentRecyclerView.setAdapter(schoolAdapter);
        showListFragmentRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
