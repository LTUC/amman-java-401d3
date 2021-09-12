package com.example.studentshub;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

// 1- Create the class without extensions ..
// 6- Extend RecyclerView.Adapter - StudentAdapter.StudentViewHolder
public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder>{

    // 2- create the list the the adapter will use to bind data
    List<Student> allStudents = new ArrayList<Student>();


    public StudentAdapter(List<Student> allStudents){
        this.allStudents = allStudents;
    }

    // 3- create the ViewHolder class (Wraps the data and the view)
    public static class StudentViewHolder extends RecyclerView.ViewHolder {
        // 4- The model object
        public Student student;
        // 5- view object
        View itemView;
        // + setting the itemView value
        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
        }
    }



    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 7- create the view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_student_item,parent,false);
        StudentViewHolder studentViewHolder = new StudentViewHolder(view);
        return studentViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        holder.student = allStudents.get(position);

        TextView studentName = holder.itemView.findViewById(R.id.studentNameInFragment);
        TextView schoolYear = holder.itemView.findViewById(R.id.schoolYeatInFragment);

        studentName.setText(holder.student.studentName);
        schoolYear.setText(Integer.toString(holder.student.schoolYear));

    }

    @Override
    public int getItemCount() {
        return allStudents.size();
    }


}
