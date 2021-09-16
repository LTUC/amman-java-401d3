package com.example.studentshub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Major;
import com.amplifyframework.datastore.generated.model.Student;

public class AddMajor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_major);

        Button submitAMajor = findViewById(R.id.submitMajor);
        submitAMajor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Major major = Major.builder().majorName("Computer Science").build();
                Amplify.API.mutate(ModelMutation.create(major),
                        response -> Log.i("MyAmplifyApp", "Added major with id "+response.getData().getId()),
                        error -> Log.e("MyAmplifyApp", "Creation failed", error)
                );

                Intent goToHome = new Intent(AddMajor.this, MainActivity.class);
                startActivity(goToHome);
            }
        });
    }
}