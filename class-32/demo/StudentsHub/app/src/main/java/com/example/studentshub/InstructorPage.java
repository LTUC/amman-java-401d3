package com.example.studentshub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InstructorPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor_page);

        Button goToHomeButton = findViewById(R.id.instructorToHome);
        goToHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToHomeIntent = new Intent(InstructorPage.this, MainActivity.class);
                startActivity(goToHomeIntent);
            }
        });

        Button submitInstructorInfo = findViewById(R.id.submitInstructorInfo);
        // same as above
        submitInstructorInfo.setOnClickListener((view)->{
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(InstructorPage.this);
            SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();

            EditText instructorNameField = findViewById(R.id.instructorNameInput);
            String instructorName = instructorNameField.getText().toString();

            sharedPreferencesEditor.putString("instructorName", instructorName);
            sharedPreferencesEditor.apply();

        });

    }
}