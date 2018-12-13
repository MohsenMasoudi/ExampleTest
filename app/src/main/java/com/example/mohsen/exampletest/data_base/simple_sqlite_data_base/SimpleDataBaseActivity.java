package com.example.mohsen.exampletest.data_base.simple_sqlite_data_base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.mohsen.exampletest.R;
import com.example.mohsen.exampletest.data_base.simple_sqlite_data_base.data_base_lab.SchoolRepository;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SimpleDataBaseActivity extends AppCompatActivity {

    private static final String TAG_ADD_SCHOOL_FRAGMENT = "tag_add_school_fragment";
    private static final String TAG_ADD_STUDENT_FRAGMENT = "tag_add_student_fragment";
    @BindView(R.id.data_base_test_fragment_container)
    LinearLayout dataBaseTestFragmentContainer;
    @BindView(R.id.brn_data_base_add_school)
    Button brnDataBaseAddSchool;
    @BindView(R.id.btn_Show_Schools)
    Button btnShowSchools;
    @BindView(R.id.btn_data_base_add_manager)
    Button btnDataBaseAddManager;
    @BindView(R.id.btn_show_managers)
    Button btnShowManagers;
    @BindView(R.id.btn_data_base_add_teacher)
    Button btnDataBaseAddTeacher;
    @BindView(R.id.ntn_show_teachers)
    Button ntnShowTeachers;
    @BindView(R.id.btn_data_base_add_student)
    Button btnDataBaseAddStudent;
    @BindView(R.id.btn_show_students)
    Button btnShowStudents;
    private FragmentManager fragmentManager;


    public static Intent newIntent(Context context) {
        return new Intent(context, SimpleDataBaseActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_base_test_layout);
        ButterKnife.bind(this);
        SchoolRepository schoolRepository = SchoolRepository.getInstance(this);
        fragmentManager = getSupportFragmentManager();

    }

    @OnClick({R.id.brn_data_base_add_school, R.id.btn_Show_Schools, R.id.btn_data_base_add_manager, R.id.btn_show_managers, R.id.btn_data_base_add_teacher, R.id.ntn_show_teachers, R.id.btn_data_base_add_student, R.id.btn_show_students})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.brn_data_base_add_school:
                SimpleDataAddSchoolFragment simpleDataAddSchoolFragment = SimpleDataAddSchoolFragment.newInstance();
                simpleDataAddSchoolFragment.show(fragmentManager, TAG_ADD_SCHOOL_FRAGMENT);
                break;
            case R.id.btn_Show_Schools:
                SimpleDataShowSchoolListFragment simpleDataShowSchoolListFragment = SimpleDataShowSchoolListFragment.newInstance();
                loadFragment(simpleDataShowSchoolListFragment);
                break;
            case R.id.btn_data_base_add_manager:
                break;
            case R.id.btn_show_managers:
                break;
            case R.id.btn_data_base_add_teacher:
                break;
            case R.id.ntn_show_teachers:
                break;
            case R.id.btn_data_base_add_student:
                SimpleDataBaseAddStudentFragment simpleDataBaseAddStudentFragment=SimpleDataBaseAddStudentFragment.newInstance();
                loadFragment(simpleDataBaseAddStudentFragment);
                break;
            case R.id.btn_show_students:
                break;
        }
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.data_base_test_fragment_container, fragment)
                .commit();
    }
}
