package edu.byui.fore.fore;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class statsActivity extends Activity {
    private Course course;
    private Integer holeNumber;

    private Integer stoppingPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        course = (Course) getIntent().getSerializableExtra("Course");

        if(course.getCurrentGame().getType().equals(GameTypes.FRONT_9)){
            stoppingPoint = 8;

        }
        else{
            stoppingPoint = 17;
        }


        holeNumber = getIntent().getIntExtra("Hole", -1);
        Integer strokes = course.getCurrentGame().getHoles().get(holeNumber).getStrokes();
        TextView textView = findViewById(R.id.holeTitle);
        textView.setText("Hole: " + ((Integer)(holeNumber + 1)).toString());

        Integer score = course.getCurrentGame().getTotal();
        Float average = course.getHoleAverage(holeNumber, strokes);

        textView = findViewById(R.id.score);
        textView.setText(score.toString());

        textView = findViewById(R.id.averageStrokes);
        textView.setText(average.toString());

        textView = findViewById((R.id.holePar));
        textView.setText(course.getPars().get(holeNumber).toString());

        textView = findViewById(R.id.currentStrokes);
        textView.setText(strokes.toString());
        //Toast.makeText(this,holeNumber.toString(),Toast.LENGTH_SHORT).show();


    }

    public void nextHole(View view){
        if (holeNumber < stoppingPoint) {
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
