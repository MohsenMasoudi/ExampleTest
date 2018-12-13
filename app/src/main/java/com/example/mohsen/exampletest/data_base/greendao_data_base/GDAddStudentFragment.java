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
import com.example.mohsen.exampletest.data_base.greendao_data_base.model.Student;
import com.example.mohsen.exampletest.data_base.greendao_data_base.model.StudentDao;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class GDAddStudentFragment extends Fragment {
    @BindView(R.id.edit_txt_enter_school_name_fragment_simple_data_base_add_student)
    EditText editTxtEnterSchoolName;
    @BindView(R.id.edit_txt_enter_school_id_fragment_simple_data_base_add_student)
    EditText editTxtEnterSchoolId;
    @BindView(R.id.edit_txt_enter_student_first_name_fragment_simple_data_base_add_student)
    EditText editTxtEnterStudentFirstName;
    @BindView(R.id.edit_txt_enter_student_family_name_fragment_simple_data_base_add_student)
    EditText editTxtEnterStudentFamilyName;
    @BindView(R.id.edit_txt_enter_student_number_fragment_simple_data_base_add_student)
    EditText editTxtEnterStudentNumber;
    @BindView(R.id.btn_save_student_fragment_simple_data_base_add_student)
    Button btnSaveStudent;
    Unbinder unbinder;
    private StudentDao studentDao;
    private SchoolDao schoolDao;
    private Long schoolId;
    private String schoolName;
    private String studentFirstName;
    private String studentFamilyName;
    private Long studentNumber;

    public GDAddStudentFragment() {
        // Required empty public constructor
    }

    public static GDAddStudentFragment newInstance() {

        Bundle args = new Bundle();
        GDAddStudentFragment fragment = new GDAddStudentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.data_base_add_student_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_save_student_fragment_simple_data_base_add_student)
    public void onViewClicked() {
        setDataToDB();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDB();
    }

    void getDB() {
        DaoSession daoSession = ((App) Objects.requireNonNull(getActivity()).getApplication()).getGreenDaoSession();
        schoolDao = daoSession.getSchoolDao();
        studentDao = daoSession.getStudentDao();
    }

    boolean getData() {
        try {
            schoolId = Long.valueOf(editTxtEnterSchoolId.getText().toString());
            schoolName = editTxtEnterSchoolName.getText().toString();
            studentFirstName = editTxtEnterStudentFirstName.getText().toString();
            studentFamilyName = editTxtEnterStudentFamilyName.getText().toString();
            studentNumber = Long.valueOf(editTxtEnterStudentNumber.getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return true;
        }
        return editTxtEnterSchoolId.getText().toString().trim().equals("")
                || editTxtEnterSchoolName.getText().toString().trim().equals("")
                || editTxtEnterStudentFirstName.getText().toString().trim().equals("")
                || editTxtEnterStudentFamilyName.getText().toString().trim().equals("")
                || editTxtEnterStudentNumber.getText().toString().trim().equals("");
    }
   void setDataToDB(){
        if(getData()){
            Toast.makeText(getActivity(), "the data is incorrect", Toast.LENGTH_SHORT).show();
        }else if(schoolDao.load(schoolId)==null){
            Toast.makeText(getActivity(), "Id is incorrect", Toast.LENGTH_SHORT).show();
        }else if(!schoolDao.load(schoolId).getName().equals(schoolName)){
            Toast.makeText(getActivity(), "name and id are not match", Toast.LENGTH_SHORT).show();

        }else {
            Student student=new Student();
            student.setSchoolId(schoolId);
            student.setFirstName(studentFirstName);
            student.setFamilyName(studentFamilyName);
            student.setStudentNumber(studentNumber);
            studentDao.insert(student);
            Toast.makeText(getActivity(), "student is added", Toast.LENGTH_SHORT).show();
            schoolDao.load(schoolId).resetStudents();
        }
    }
}
