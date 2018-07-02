package edu.byui.fore.fore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class statsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        ArrayList<Course> Courses = (ArrayList<Course>) getIntent().getSerializableExtra("Courses");
        Course course = (Course) getIntent().getSerializableExtra("Course");

        Integer holeNumber = getIntent().getIntExtra("Hole", -1);
        Integer score = course.getCurrentGame().getTotal();
        Integer average = course.getHoleAverage(holeNumber);

        TextView textView = findViewById(R.id.score);
        textView.setText(score.toString());

        textView = findViewById(R.id.averageStrokes);
        textView.setText(average.toString());

        textView = findViewById(R.id.currentStrokes);
        textView.setText((Integer)course.getCurrentGame().getHoles().get(holeNumber).getStrokes());


    }

    public void nextHole(View view){

        Intent intent = new Intent(this, strokeCounter_activity.class);
        intent.putExtra("Hole", getIntent().getIntExtra("Hole", -1) + 1);
    }
}
