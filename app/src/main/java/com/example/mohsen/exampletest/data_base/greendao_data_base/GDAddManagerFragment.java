package com.example.mohsen.exampletest.data_base.greendao_data_base;


import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.example.mohsen.exampletest.data_base.greendao_data_base.model.Manager;
import com.example.mohsen.exampletest.data_base.greendao_data_base.model.ManagerDao;
import com.example.mohsen.exampletest.data_base.greendao_data_base.model.School;
import com.example.mohsen.exampletest.data_base.greendao_data_base.model.SchoolDao;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class GDAddManagerFragment extends DialogFragment {

    @BindView(R.id.edit_txt_enter_id_fragment_green_dao_add_manager_first_name)
    EditText editTxtEnterId;
    @BindView(R.id.edit_txt_enter_last_Name_fragment_green_dao_add_manager_first_name)
    EditText editTxtEnterLastName;
    @BindView(R.id.edit_txt_add_firs_name_fragment_green_dao_add_manager_first_name)
    EditText editTxtAddFirsName;
    @BindView(R.id.btn_add_manager_first_name_fragment_green_dao_add_manager_first_name)
    Button btnAddManagerFirstName;
    Unbinder unbinder;
    private ManagerDao managerDao;
    private SchoolDao schoolDao;
    private Manager manager;
    private String managerFirstName;
    private String managerLastName;
    private Long schoolId;
    private boolean isProblem;
    private Long managerId;
    private School school;

    public GDAddManagerFragment() {
        // Required empty public constructor
    }

    public static GDAddManagerFragment newInstance() {
        Bundle args = new Bundle();
        GDAddManagerFragment fragment = new GDAddManagerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDB();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.data_base_add_manager_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    void getDB() {
        DaoSession daoSession = ((App) Objects.requireNonNull(getActivity()).getApplication()).getGreenDaoSession();
        managerDao = daoSession.getManagerDao();
        schoolDao = daoSession.getSchoolDao();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_add_manager_first_name_fragment_green_dao_add_manager_first_name)
    public void onViewClicked() {
//        getProperties();
        if (getProperties()||editTxtEnterId.getText() == null
                || editTxtEnterId.getText() == null
                || editTxtAddFirsName.getText() == null
                || editTxtEnterId.getText().toString().equals("")
                || editTxtEnterLastName.getText().toString().equals("")
                || editTxtAddFirsName.getText().toString().equals("")) {
            Toast.makeText(getContext(), "fill the blanks", Toast.LENGTH_SHORT).show();

        } else if ((schoolDao.load(Long.valueOf(editTxtEnterId.getText().toString()))) == null) {
            Toast.makeText(getActivity(), "Id doesn't Exist", Toast.LENGTH_SHORT).show();

        } else {
            if(( manager=schoolDao.loadDeep(schoolId).getManager())==null){
                manager=new Manager();
            }

            manager.setFirstName(managerFirstName);
            manager.setLastName(managerLastName);
            managerDao.insertOrReplace(manager);
            managerId=managerDao.getKey(manager);
            school = schoolDao.loadDeep(schoolId);
            school.setManager(manager);
            school.setManagerId(managerId);
            schoolDao.update(school);
            Toast.makeText(getActivity(), "Manager is Added", Toast.LENGTH_SHORT).show();
        }
        dismiss();
    }

    boolean getProperties() {

        try {
            schoolId = Long.valueOf(editTxtEnterId.getText().toString());
            managerFirstName = editTxtAddFirsName.getText().toString();
            managerLastName = editTxtEnterLastName.getText().toString();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return true;
        }
        return false;
    }
}
