package com.example.studentshub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Major;
import com.amplifyframework.datastore.generated.model.Student;

import java.util.concurrent.atomic.AtomicReference;

public class AddStudentActivity extends AppCompatActivity {

    public String studentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        AtomicReference<Major> major = null;
        studentId = getIntent().getExtras().get("id").toString();

        EditText studentName = findViewById(R.id.StudentNameInput);
        EditText schoolYear = findViewById(R.id.ClassYearInput);

        Button goToHomeButton = findViewById(R.id.studentToHome);
        goToHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Amplify.API.query(
                        ModelQuery.get(Major.class, "b6799fa3-0414-46e2-9a74-2454028db2f7"),
                        response -> {
                           // major.set(();
                            Log.i("MyAmplifyApp", ((Major) response.getData()).getMajorName());

                            Student student = Student.builder().studentname(studentName.getText().toString()).schoolyear(Integer.parseInt(schoolYear.getText().toString())).studentMajor((Major) response.getData()).build();
                            Amplify.API.mutate(ModelMutation.create(student),
                                    secondResponse -> Log.i("MyAmplifyApp", "Added student with id "+response.getData().getId()),
                                    error -> Log.e("MyAmplifyApp", "Creation failed", error)
                            );
                        },
                        error -> Log.e("MyAmplifyApp", error.toString(), error)
                );



                Intent goToHome = new Intent(AddStudentActivity.this, MainActivity.class);
                startActivity(goToHome);
            }
        });
    }
}