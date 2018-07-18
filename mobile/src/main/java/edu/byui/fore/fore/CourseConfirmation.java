package edu.byui.fore.fore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CourseConfirmation extends AppCompatActivity {
    private Course course2play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_confirmation);
        course2play = (Course) getIntent().getSerializableExtra("Course");

        TextView textView = findViewById(R.id.CourseConfirmation);
        textView.setText(course2play.getName());

        Toast.makeText(this,Float.toString(course2play.distanceTo(course2play)),
                Toast.LENGTH_SHORT).show();
    }

    public void submitCourse(View v) {
        int hole = 0;
        //If the Back 9 gametype was selected, we will want to start at hole 9
        if(course2play.getCurrentGame().getType().equals(GameTypes.BACK_9)){
            hole = 9;
        }

        //start the timer
        course2play.getCurrentGame().startTime();

        //kick it off to the strokeCounter activity
        Intent intent = new Intent(this, strokeCounter_activity.class);
        intent.putExtra("Course", course2play);
        intent.putExtra("Courses", getIntent().getSerializableExtra("Courses"));
        intent.putExtra("Hole", hole);
        startActivity(intent);
    }

    public void goBack(View v) {
        Intent intent = new Intent(this, Course_Selection.class);
        intent.putExtra("Courses", getIntent().getSerializableExtra("Courses"));
        startActivity(intent);
    }
}
