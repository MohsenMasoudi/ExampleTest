package com.example.mohsen.exampletest.data_base.greendao_data_base;

import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.example.mohsen.exampletest.data_base.greendao_data_base.model.SchoolDao;
import com.example.mohsen.exampletest.data_base.greendao_data_base.model.Teacher;
import com.example.mohsen.exampletest.data_base.greendao_data_base.model.TeacherDao;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class GDAddTeacherFragment extends Fragment {

    @BindView(R.id.edit_txt_enter_school_name_fragment_layout_add_teacher)
    EditText editTxtEnterSchoolName;
    @BindView(R.id.edit_txt_enter_school_id_fragment_layout_add_teacher)
    EditText editTxtEnterSchoolId;
    @BindView(R.id.edit_txt_enter_teacher_first_name_fragment_layout_add_teacher)
    EditText editTxtEnterTeacherFirstName;
    @BindView(R.id.edit_txt_enter_teacher_family_name_fragment_layout_add_teacher)
    EditText editTxtEnterTeacherFamilyName;
    @BindView(R.id.btn_save_teacher_fragment_layout_add_teacher)
    Button btnSaveTeacher;
    Unbinder unbinder;
    private Long schoolId;
    private Long teacerId;
    private String schoolName;
    private String teacherFirstName;
    private String teacherFamilyName;
    private TeacherDao teacherDao;
    private SchoolDao schoolDao;

    public GDAddTeacherFragment() {
        // Required empty public constructor
    }

    public static GDAddTeacherFragment newInstance() {

        Bundle args = new Bundle();

        GDAddTeacherFragment fragment = new GDAddTeacherFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDB();
    }

    void getDB() {
        DaoSession daoSession = ((App) Objects.requireNonNull(getActivity()).getApplication()).getGreenDaoSession();
        teacherDao = daoSession.getTeacherDao();
        schoolDao = daoSession.getSchoolDao();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.data_base_add_teacher_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.btn_save_teacher_fragment_layout_add_teacher)
    public void onViewClicked() {
        if (getData()) {
            Toast.makeText(getActivity(), "the Values are incorrect", Toast.LENGTH_SHORT).show();
        } else if (schoolDao.load(schoolId) == null) {
            Toast.makeText(getActivity(), "this Id doesn't Exist", Toast.LENGTH_SHORT).show();
        } else if (!schoolDao.load(schoolId).getName().equals(schoolName)) {
            Toast.makeText(getActivity(), "the name and Id of school does not match", Toast.LENGTH_SHORT).show();
        } else {
            setDataToDB();
            Toast.makeText(getActivity(), "data is added", Toast.LENGTH_SHORT).show();
        }
    }

    boolean getData() {

        try {
            schoolId = Long.valueOf(editTxtEnterSchoolId.getText().toString());
            schoolName = editTxtEnterSchoolName.getText().toString();
            teacherFirstName = editTxtEnterTeacherFirstName.getText().toString();
            teacherFamilyName = editTxtEnterTeacherFamilyName.getText().toString();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return true;
        }
        if (editTxtEnterSchoolId.getText() == null
                || editTxtEnterSchoolName.getText() == null
                || editTxtEnterTeacherFirstName.getText() == null
                || editTxtEnterTeacherFamilyName.getText() == null
                || editTxtEnterSchoolId.getText().toString().trim().equals("")
                || editTxtEnterSchoolName.getText().toString().trim().equals("")
                || editTxtEnterTeacherFirstName.getText().toString().trim().equals("")
                || editTxtEnterTeacherFamilyName.getText().toString().trim().equals("")) {
            return true;
        } else
            return false;
    }

    void setDataToDB() {
        Teacher teacher = new Teacher();
        teacher.setFirstName(teacherFirstName);
        teacher.setFamilyName(teacherFamilyName);
        teacher.setSchoolId(schoolId);
        teacherDao.insert(teacher);
        schoolDao.load(schoolId).resetTeachers();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
