package com.example.mohsen.exampletest.data_base.simple_sqlite_data_base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mohsen.exampletest.R;
import com.example.mohsen.exampletest.data_base.simple_sqlite_data_base.data_base_lab.SchoolRepository;
import com.example.mohsen.exampletest.data_base.simple_sqlite_data_base.model.School;
import com.example.mohsen.exampletest.data_base.simple_sqlite_data_base.model.Student;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import butterknife.Unbinder;


public class SimpleDataBaseAddStudentFragment extends Fragment {
    @BindView(R.id.edit_txt_enter_school_name_fragment_simple_data_base_add_student)
    EditText editTxtEnterSchoolName;
    @BindView(R.id.edit_txt_enter_school_id_fragment_simple_data_base_add_student)
    EditText editTxtEnterSchoolId;
    @BindView(R.id.edit_txt_enter_student_first_name_fragment_simple_data_base_add_student)
    EditText editEnterStudentFirstName;
    @BindView(R.id.edit_txt_enter_student_family_name_fragment_simple_data_base_add_student)
    EditText editEnterStudentFamilyName;
    @BindView(R.id.edit_txt_enter_student_number_fragment_simple_data_base_add_student)
    EditText editEnterStudentNumber;
    @BindView(R.id.btn_save_student_fragment_simple_data_base_add_student)
    Button btnSaveStudent;
    Unbinder unbinder;
    ArrayList<UUID> studentIdList ;
    private String firstName;
    private String familyName;
    private long studentNumber;
    private String schoolName;
    private Integer schoolId;


    public static SimpleDataBaseAddStudentFragment newInstance() {

        Bundle args = new Bundle();

        SimpleDataBaseAddStudentFragment fragment = new SimpleDataBaseAddStudentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
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
        if (schoolName == null) {
            Toast.makeText(getActivity(), "Enter School Name", Toast.LENGTH_SHORT).show();
        } else if (schoolId == null) {
            Toast.makeText(getActivity(), "Enter School ID", Toast.LENGTH_SHORT).show();
        } else if (schoolId < Integer.MIN_VALUE||schoolId>=Integer.MAX_VALUE) {
            Toast.makeText(getActivity(), "Enter valid ID", Toast.LENGTH_SHORT).show();

        } else if (SchoolRepository.getInstance(getActivity()).getSchool(schoolId) == null) {
            Toast.makeText(getActivity(), "School With This Id Does Not Exist"+schoolId, Toast.LENGTH_SHORT).show();
        } else if (firstName == null || firstName.equals("")) {
            Toast.makeText(getActivity(), "Enter FirstContract Name", Toast.LENGTH_SHORT).show();
        } else if (familyName == null || familyName.equals("")) {
            Toast.makeText(getActivity(), "Enter Family Name", Toast.LENGTH_SHORT).show();
        } else if (studentNumber <= 0) {
            Toast.makeText(getActivity(), "Enter Student Number", Toast.LENGTH_SHORT).show();
        } else {
            addStudent();

        }

    }

    private void addStudent() {
        Student student = new Student();
        student.setFirstName(firstName);
        student.setFamilyName(familyName);
        student.setStudentNumber(studentNumber);
        School school = SchoolRepository.getInstance(getActivity()).getSchool(schoolId);
        studentIdList=new ArrayList<>();
        studentIdList=school.getStudents();
        studentIdList.add(student.getId());
        SchoolRepository.getInstance(getActivity()).updateSchool(school);
        SchoolRepository.getInstance(getActivity()).addStudent(student);
    }

    @OnTextChanged(value = {
            R.id.edit_txt_enter_school_name_fragment_simple_data_base_add_student
            , R.id.edit_txt_enter_school_id_fragment_simple_data_base_add_student
            , R.id.edit_txt_enter_student_first_name_fragment_simple_data_base_add_student
            , R.id.edit_txt_enter_student_family_name_fragment_simple_data_base_add_student
            , R.id.edit_txt_enter_student_number_fragment_simple_data_base_add_student
    },
            callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void input(Editable editable) {
        View view;
        view = Objects.requireNonNull(getActivity()).getCurrentFocus();
        assert view != null;
        switch (view.getId()) {
            case R.id.edit_txt_enter_school_name_fragment_simple_data_base_add_student:
                schoolName = editable.toString();
                break;
            case R.id.edit_txt_enter_school_id_fragment_simple_data_base_add_student:

                if (!editable.toString().equals("")) {
                    try {
                        schoolId = Integer.parseInt(editable.toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case R.id.edit_txt_enter_student_first_name_fragment_simple_data_base_add_student:
                firstName = editable.toString();
                break;
            case R.id.edit_txt_enter_student_family_name_fragment_simple_data_base_add_student:
                familyName = editable.toString();
                break;
            case R.id.edit_txt_enter_student_number_fragment_simple_data_base_add_student:
                if (!editable.toString().equals("")) {
                    studentNumber = Long.parseLong(editable.toString());
                }
                break;
        }
    }


}


