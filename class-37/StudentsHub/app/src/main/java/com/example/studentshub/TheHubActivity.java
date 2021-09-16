package com.example.studentshub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Student;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class TheHubActivity extends AppCompatActivity {

    RecyclerView allStudentsRecuclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_hub);

        Handler handler = new Handler(Looper.getMainLooper(),
                // job is to allow a thread to send the main thread an action or message
                new Handler.Callback() {
                    @Override
                    public boolean handleMessage(@NonNull Message message) {
                        allStudentsRecuclerView.getAdapter().notifyDataSetChanged();
                        return false;
                    }
                });

        // Create some data
        ArrayList<Student> allStudents = new ArrayList<Student>();
        allStudentsRecuclerView = findViewById(R.id.StudentListRecyclerView);
        allStudentsRecuclerView.setLayoutManager(new LinearLayoutManager(this));
        allStudentsRecuclerView.setAdapter(new StudentAdapter(allStudents));



        Amplify.API.query(
                ModelQuery.list(com.amplifyframework.datastore.generated.model.Student.class),
                response -> {
                    for (Student student : response.getData()) {
                        Log.i("MyAmplifyApp", "inside the loop");
                        Log.i("MyAmplifyApp", student.getStudentname());
                        allStudents.add(student);
                    }
                    handler.sendEmptyMessage(1);
                    Log.i("MyAmplifyApp", "outside the loop");



                },
                error -> Log.e("MyAmplifyApp", "Query failure", error)
        );

        Log.i("MyAmplifyApp", "the recycler view code ... ");

        // get the recycler view

        // set a layout manager for this view

        // set the adapter for this recyclerView
        

    }
}