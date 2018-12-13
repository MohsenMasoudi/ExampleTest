package com.example.mohsen.exampletest.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mohsen.exampletest.R;
import com.example.mohsen.exampletest.view.model.student_model.Student;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewPagerFragment extends Fragment {
    private static String ARGS_VIEW_PAGER_FRAGMENT = "args_view_pager_activity";
    @BindView(R.id.txt_id_viewpager_fragment)
    TextView txtIdViewpagerFragment;
    @BindView(R.id.txt_name_viewpager_fragment)
    TextView txtNameViewpagerFragment;
    @BindView(R.id.txt_family_viewpager_fragment)
    TextView txtFamilyViewpagerFragment;
    Unbinder unbinder;
    private int id;


    public ViewPagerFragment() {
        // Required empty public constructor
    }

    public static ViewPagerFragment newInstance(int id) {
        Bundle args = new Bundle();
        args.putInt(ARGS_VIEW_PAGER_FRAGMENT, id);
        ViewPagerFragment fragment = new ViewPagerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.view_pager_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        if (getArguments() != null) {
            id = getArguments().getInt(ARGS_VIEW_PAGER_FRAGMENT);
        } else {
            id = 0;
        }
        Student student = new Student();
        student.setStudent(id, student);
        txtIdViewpagerFragment.setText(student.getId()+"");
        txtNameViewpagerFragment.setText(student.getName());
        txtFamilyViewpagerFragment.setText(student.getFamilyName());
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.txt_id_viewpager_fragment, R.id.txt_name_viewpager_fragment, R.id.txt_family_viewpager_fragment})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.txt_id_viewpager_fragment:
                Toast.makeText(getActivity(), "id", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txt_name_viewpager_fragment:
                Toast.makeText(getActivity(), "name", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txt_family_viewpager_fragment:
                Toast.makeText(getActivity(), "family", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
