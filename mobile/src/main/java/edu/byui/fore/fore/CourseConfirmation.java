package edu.byui.fore.fore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CourseConfirmation extends AppCompatActivity {
    private Course course2play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_confirmation);
        course2play = (Course) getIntent().getSerializableExtra("Course");

        TextView textView = findViewById(R.id.CourseConfirmation);
        textView.setText(course2play.getName());
    }

    public void submitCourse(View v) {
        Intent intent = new Intent(this, strokeCounter_activity.class);
        intent.putExtra("Course", course2play);
        intent.putExtra("Courses", getIntent().getSerializableExtra("Courses"));
        intent.putExtra("Hole", 0);
        startActivity(intent);
    }

    public void goBack(View v) {
        Intent intent = new Intent(this, Course_Selection.class);
        intent.putExtra("Courses", getIntent().getSerializableExtra("Courses"));
        startActivity(intent);
    }
}
