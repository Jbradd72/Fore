package edu.byui.fore.fore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CourseConfirmation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_confirmation);
        Course course2play = (Course)getIntent().getSerializableExtra("Course");

        TextView textView = findViewById(R.id.CourseConfirmation);
        textView.setText(course2play.getName());
    }
}
