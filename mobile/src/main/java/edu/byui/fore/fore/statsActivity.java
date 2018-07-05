package edu.byui.fore.fore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class statsActivity extends AppCompatActivity {
    private Course course;
    private Integer holeNumber;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        course = (Course) getIntent().getSerializableExtra("Course");

        holeNumber = getIntent().getIntExtra("Hole", -1);
        Integer score = course.getCurrentGame().getTotal();
        Integer average = course.getHoleAverage(holeNumber);

        TextView textView = findViewById(R.id.score);
        textView.setText(score.toString());

        textView = findViewById(R.id.averageStrokes);
        textView.setText(average.toString());

        textView = findViewById(R.id.currentStrokes);
        textView.setText(((Integer)(course.getCurrentGame().getHoles().get(holeNumber).getStrokes())).toString());
        Toast.makeText(this,holeNumber.toString(),Toast.LENGTH_SHORT).show();


    }

    public void nextHole(View view){
        if (holeNumber < 17) {
            Intent intent = new Intent(this, strokeCounter_activity.class);
            intent.putExtra("Hole", getIntent().getIntExtra("Hole", -1) + 1);
            intent.putExtra("Course", course);
            intent.putExtra("Courses", getIntent().getSerializableExtra("Courses"));
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(this, GameSummaryActivity.class);
            intent.putExtra("Course", course);
            intent.putExtra("Courses", getIntent().getSerializableExtra("Courses"));
            startActivity(intent);
        }

    }
}
