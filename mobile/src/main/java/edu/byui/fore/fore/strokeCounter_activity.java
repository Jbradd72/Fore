package edu.byui.fore.fore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class strokeCounter_activity extends AppCompatActivity {
    private Integer strokes;
    private Integer holeNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stroke_counter);
        strokes = 0;
        holeNumber = getIntent().getIntExtra("Hole", -1);

        if (holeNumber < 0){
            Log.wtf("STROKE COUNTER ACTIVITY", "Negative Hole Number");
        }
    }

    public void incrementStrokes(View view){
        strokes++;

        TextView textView = findViewById(R.id.strokes_display);

        textView.setText(strokes.toString());
    }

    public void decrementStrokes(View view){
        strokes--;

        TextView textView = findViewById(R.id.strokes_display);

        textView.setText(strokes.toString());
    }
    public void resetStrokes(View view){
        strokes = 0;

        TextView textView = findViewById(R.id.strokes_display);

        textView.setText(strokes.toString());
    }
    public void submit(View view){
        Course course = (Course) getIntent().getSerializableExtra("Course");
        course.getCurrentGame().getHoles().get(holeNumber).setStrokes(strokes);
        course.getCurrentGame().setTotal(strokes + course.getCurrentGame().getTotal());

        Intent intent = new Intent(this, statsActivity.class);
        intent.putExtra("Course", course);
        intent.putExtra("Courses", getIntent().getSerializableExtra("Courses"));
        intent.putExtra("Hole", holeNumber);
        startActivity(intent);


    }
}
