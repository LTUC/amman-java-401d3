package com.example.studentshub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // move to on resume
        String welcomeMessage = "Welcome ";
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        String instructorName = sharedPreferences.getString("instructorName", "Instructor");

        TextView instructorNameView = findViewById(R.id.welcomeMessage);
        instructorNameView.setText(welcomeMessage + instructorName);
        // ---- end of code to add to on resume ----

        Button addStudentButton = findViewById(R.id.addStudentButton);
        Button allStudents = findViewById(R.id.allStudentsButton);
        Button instructorPage = findViewById(R.id.instructorPageButton);

        addStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToAddStudent = new Intent(MainActivity.this, AddStudentActivity.class);
                startActivity(goToAddStudent);
            }
        });

        allStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        instructorPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToInstructorPage = new Intent(MainActivity.this, InstructorPage.class);
                startActivity(goToInstructorPage);
            }
        });




    }


}