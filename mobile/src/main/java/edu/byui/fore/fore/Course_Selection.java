package edu.byui.fore.fore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Course_Selection extends AppCompatActivity {
    private List<Course> courseList;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course__selection);

        courseList = (List<Course>)getIntent().getSerializableExtra("Courses");
        List<String> courseNamesList = new ArrayList<>();

        for (Course course : courseList){
            courseNamesList.add(course.getName());
        }

        Spinner s = findViewById(R.id.courseSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, courseNamesList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);

        mTextView = findViewById(R.id.text);
    }

    public void confirmCourse(View v){
        Spinner s = findViewById(R.id.courseSpinner);
        String name = s.getSelectedItem().toString();
        Course course2play = new Course();

        for (Course course : courseList){
            if(name.equals(course.getName())){
                course2play = course;
            }
        }

        Intent tutorialPage = new Intent(this, CourseConfirmation.class);
        tutorialPage.putExtra("Course", course2play);
        startActivity(tutorialPage);
    }
}
