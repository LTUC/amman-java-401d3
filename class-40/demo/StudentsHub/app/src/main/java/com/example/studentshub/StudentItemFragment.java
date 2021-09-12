package com.example.studentshub;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StudentItemFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StudentItemFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "studentName";
    private static final String ARG_PARAM2 = "schoolYear";

    // TODO: Rename and change types of parameters
    private String mStudentName;
    private int mSchoolYear;

    public StudentItemFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param mStudentName Parameter 1.
     * @param mSchoolYear Parameter 2.
     * @return A new instance of fragment StudentItemFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StudentItemFragment newInstance(String mStudentName, int mSchoolYear) {
        StudentItemFragment fragment = new StudentItemFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, mStudentName);
        args.putInt(ARG_PARAM2, mSchoolYear);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mStudentName = getArguments().getString(ARG_PARAM1);
            mSchoolYear = getArguments().getInt(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_item, container, false);
    }
}