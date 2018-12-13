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
import android.widget.Toast;

import com.example.mohsen.exampletest.App;
import com.example.mohsen.exampletest.R;
import com.example.mohsen.exampletest.data_base.greendao_data_base.model.DaoSession;
import com.example.mohsen.exampletest.data_base.greendao_data_base.model.Manager;
import com.example.mohsen.exampletest.data_base.greendao_data_base.model.ManagerDao;

import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class GDShowManagerListFragment extends Fragment {

    @BindView(R.id.show_list_fragment_recycler_view)
    RecyclerView showListFragmentRecyclerView;
    Unbinder unbinder;
    ManagerAdapter managerAdapter;
    private ManagerDao managerDao;

    public GDShowManagerListFragment() {
        // Required empty public constructor
    }

    public static GDShowManagerListFragment newInstance() {

        Bundle args = new Bundle();

        GDShowManagerListFragment fragment = new GDShowManagerListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.recycler_view_layout, container, false);
        unbinder = ButterKnife.bind(this, view);
        setRecyclerView();
        return view;
    }

    void setRecyclerView() {
        ArrayList<Manager> managerArrayList = new ArrayList<Manager>();
        try {
            managerArrayList = (ArrayList<Manager>) managerDao.loadAll();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getActivity(), "we have problem", Toast.LENGTH_SHORT).show();
        }
        managerAdapter = new ManagerAdapter(managerArrayList);
        showListFragmentRecyclerView.setAdapter(managerAdapter);
        showListFragmentRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDB();
    }

    void getDB() {
        DaoSession daoSession = ((App) Objects.requireNonNull(getActivity()).getApplication()).getGreenDaoSession();
        managerDao = daoSession.getManagerDao();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private class ManagerHolder extends RecyclerView.ViewHolder {
        private TextView mTxtId;
        private TextView mTxtFirstName;
        private TextView mTxtLastName;

        public ManagerHolder(@NonNull View itemView) {
            super(itemView);
            mTxtId = itemView.findViewById(R.id.txt_id_person_item_in_list_view);
            mTxtFirstName = itemView.findViewById(R.id.txt_first_name_person_item_in_list_view);
            mTxtLastName = itemView.findViewById(R.id.txt_last_name_person_item_in_list_view);

        }

        @SuppressLint("DefaultLocale")
        public void bindUI(com.example.mohsen.exampletest.data_base.greendao_data_base.model.Manager manager) {
            mTxtId.setText(String.format("%d", manager.getId()));
            mTxtFirstName.setText(manager.getFirstName());
            mTxtLastName.setText(manager.getLastName());
        }

    }

    private class ManagerAdapter extends RecyclerView.Adapter<ManagerHolder> {
        private ArrayList<Manager> managerList;

        public ManagerAdapter(ArrayList<Manager> managerList) {
            this.managerList = managerList;
        }

        @NonNull
        @Override
        public ManagerHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.data_base_person_item_in_list_view, viewGroup, false);
            return new ManagerHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ManagerHolder managerHolder, int i) {
            com.example.mohsen.exampletest.data_base.greendao_data_base.model.Manager manager = managerList.get(i);
            managerHolder.bindUI(manager);

        }

        @Override
        public int getItemCount() {
            return managerList.size();
        }

    }
}
