package edu.byui.fore.fore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Course> courseList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectCourse(View view){
        startActivity(new Intent(this, Course_Selection.class));
    }

    public void addCourse(View view){
        startActivity(new Intent(this, AddCourseActivity.class));
    }
}
