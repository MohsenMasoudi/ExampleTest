package com.example.mohsen.exampletest.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mohsen.exampletest.R;
import com.example.mohsen.exampletest.view.model.student_model.Student;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewActivity extends AppCompatActivity {

    public static Intent getNewIntent(Context context) {
        return new Intent(context, RecyclerViewActivity.class);
    }

    @BindView(R.id.recycler_view_example)
    RecyclerView recyclerViewExample;
    ExampleAdapter exampleAdapter;

    class ExampleViewHolder extends RecyclerView.ViewHolder {
        private TextView txtIdRecycler;
        private TextView txtNameRecycler;
        private TextView txtFamilyRecycler;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            txtIdRecycler = itemView.findViewById(R.id.txt_id_recycler_view_example_item);
            txtNameRecycler = itemView.findViewById(R.id.txt_name_recycler_view_example_item);
            txtFamilyRecycler = itemView.findViewById(R.id.txt_family_recycler_view_example_item);

        }

        void bindUI(Student student) {
            txtIdRecycler.setText(String.format("%d", student.getId()));
            txtNameRecycler.setText(student.getName());
            txtFamilyRecycler.setText(student.getFamilyName());
        }

    }


    private class ExampleAdapter extends RecyclerView.Adapter<ExampleViewHolder> {
        ArrayList<Student> students;

        public ExampleAdapter(ArrayList<Student> students) {
            this.students = students;
        }

        @NonNull
        @Override
        public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater layoutInflater = LayoutInflater.from(getApplicationContext());
            View view = layoutInflater.inflate(R.layout.recycler_view_example_item, viewGroup, false);
            return new ExampleViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ExampleViewHolder exampleViewHolder, int i) {
            exampleViewHolder.bindUI(students.get(i));

        }

        @Override
        public int getItemCount() {
            return students.size();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_recycler_activity);
        ButterKnife.bind(this);
        recyclerViewExample.setLayoutManager(new LinearLayoutManager(this));
        exampleAdapter = new ExampleAdapter(Student.getStudents(10));
        recyclerViewExample.setAdapter(exampleAdapter);
    }
}
