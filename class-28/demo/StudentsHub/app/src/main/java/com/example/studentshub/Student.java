package com.example.studentshub;

// First step: create the model class
// Second: create the fragment (represents a single item)
// Create the adapter:
// Create the RecyclerView object in the desired activity , set the layout manager (linear layout manager), set the adapter

public class Student {
    public String studentName;
    public int schoolYear;

    public Student(String studentName, int schoolYear){
        this.studentName = studentName;
        this.schoolYear = schoolYear;
    }
}
