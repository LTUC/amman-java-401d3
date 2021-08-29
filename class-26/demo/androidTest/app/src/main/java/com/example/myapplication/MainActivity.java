package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // document.getElementById(elementIdWeAreTargeting)
        Button firstButton = findViewById(R.id.button);
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "The button was clicked!", Toast.LENGTH_LONG).show();
                EditText userName = findViewById(R.id.editTextTextPersonName);
                String userNameValue = userName.getText().toString();

                // move to a new activity using an intent
                Intent goToProfile = new Intent(MainActivity.this, profile.class);
                // append value to intent
                goToProfile.putExtra("userName",userNameValue);
                startActivity(goToProfile);
            }
        });


    }

    // override all callbacks (onCreate, onStart, onResume, onPause, onStop, onRestart, onDestroy)
    // add toast with state name for each

}