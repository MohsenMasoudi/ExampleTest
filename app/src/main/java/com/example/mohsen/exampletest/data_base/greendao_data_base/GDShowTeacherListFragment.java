package com.example.mohsen.exampletest.data_base.greendao_data_base;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import com.example.mohsen.exampletest.data_base.greendao_data_base.model.Teacher;
import com.example.mohsen.exampletest.data_base.greendao_data_base.model.TeacherDao;

import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class GDShowTeacherListFragment extends Fragment {
    @BindView(R.id.show_list_fragment_recycler_view)
    RecyclerView recyclerView;
    Unbinder unbinder;
    private TeacherDao teacherDao;
    private TeacherAdapter teacherAdapter;

    public GDShowTeacherListFragment() {
        // Required empty public constructor
    }

    public static GDShowTeacherListFragment newInstance() {
        Bundle args = new Bundle();
        GDShowTeacherListFragment fragment = new GDShowTeacherListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view_layout, container, false);
        unbinder = ButterKnife.bind(this, view);
        ArrayList<Teacher> teachers=(ArrayList<Teacher>) teacherDao.loadAll();
        setRecyclerView(teachers);
        return view;
    }

    void setRecyclerView(ArrayList<Teacher> teacherArrayList) {
        teacherAdapter = new TeacherAdapter(teacherArrayList);
        recyclerView.setAdapter(teacherAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        getDB();
    }

    void getDB() {
        DaoSession daoSession = ((App) Objects.requireNonNull(getActivity()).getApplication()).getGreenDaoSession();
        teacherDao = daoSession.getTeacherDao();
    }

    private class TeacherHolder extends RecyclerView.ViewHolder {
        private TextView mTxtId;
        private TextView mTxtFirstName;
        private TextView mTxtLastName;

        public TeacherHolder(@NonNull View itemView) {
            super(itemView);
            mTxtId = itemView.findViewById(R.id.txt_id_person_item_in_list_view);
            mTxtFirstName = itemView.findViewById(R.id.txt_first_name_person_item_in_list_view);
            mTxtLastName = itemView.findViewById(R.id.txt_last_name_person_item_in_list_view);

        }

        @SuppressLint("DefaultLocale")
        public void bindUI(Teacher teacher) {
            mTxtId.setText(String.format("%d", teacher.getId()));
            mTxtFirstName.setText(teacher.getFirstName());
            mTxtLastName.setText(teacher.getFamilyName());
        }
    }

    private class TeacherAdapter extends RecyclerView.Adapter<TeacherHolder> {
        ArrayList<Teacher> teachers;

        public TeacherAdapter(ArrayList<Teacher> teachers) {
            this.teachers = teachers;
        }

        @NonNull
        @Override
        public TeacherHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.data_base_person_item_in_list_view, viewGroup, false);
            return new TeacherHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull TeacherHolder teacherHolder, int i) {
            Teacher teacher =teachers.get(i);
            teacherHolder.bindUI(teacher);

        }

        @Override
        public int getItemCount() {
            return teachers.size();
        }
    }
}
