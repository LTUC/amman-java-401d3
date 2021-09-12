package com.example.studentshub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class TheHubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_hub);

        // Create some data
        ArrayList<Student> allStudents = new ArrayList<Student>();
        allStudents.add(new Student("Abdalla",2020));
        allStudents.add(new Student("Ahmad",2019));
        allStudents.add(new Student("Rawan",2015));
        allStudents.add(new Student("Mohammad",2014));
        allStudents.add(new Student("Maram",2016));

        // get the recycler view
        RecyclerView allStudentsRecuclerView = findViewById(R.id.StudentListRecyclerView);
        // set a layout manager for this view
        allStudentsRecuclerView.setLayoutManager(new LinearLayoutManager(this));
        // set the adapter for this recyclerView
        allStudentsRecuclerView.setAdapter(new StudentAdapter(allStudents));

    }
}