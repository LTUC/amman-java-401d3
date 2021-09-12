package com.example.studentshub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        EditText studentName = findViewById(R.id.StudentNameInput);
        EditText schoolYear = findViewById(R.id.ClassYearInput);

        Button goToHomeButton = findViewById(R.id.studentToHome);
        goToHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToHome = new Intent(AddStudentActivity.this, MainActivity.class);
                startActivity(goToHome);
            }
        });
    }
}