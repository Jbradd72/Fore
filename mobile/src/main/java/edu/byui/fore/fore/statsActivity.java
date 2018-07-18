package edu.byui.fore.fore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * the stats activity displays the stat data to the player between each hole. it contains information
 * from the course, and the number of the hole
 */
public class statsActivity extends AppCompatActivity {
    private Course course;
    private Integer holeNumber;

    private Integer stoppingPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        course = (Course) getIntent().getSerializableExtra("Course");

        //Which hole we stop at depends on the gametype that was selected
        if(course.getCurrentGame().getType().equals(GameTypes.FRONT_9)){
            stoppingPoint = 8;

        }
        else{
            stoppingPoint = 17;
        }

        holeNumber = getIntent().getIntExtra("Hole", -1);

        //The rest of the onCreate method is simply populating the textViews with the information we
        //want to display
        TextView textView = findViewById(R.id.holeTitle);
        textView.setText("Hole: " + ((Integer)(holeNumber + 1)).toString());

        Integer score = course.getCurrentGame().getTotal();
        Float average = course.getHoleAverage(holeNumber);

        textView = findViewById(R.id.score);
        textView.setText(score.toString());

        textView = findViewById(R.id.averageStrokes);
        textView.setText(average.toString());

        textView = findViewById((R.id.holePar));
        textView.setText(course.getPars().get(holeNumber).toString());

        textView = findViewById(R.id.currentStrokes);
        textView.setText(((Integer)(course.getCurrentGame().getHoles().get(holeNumber).getStrokes())).toString());


    }

    /**
     * changes the activity to the next hole, depending on the type of game played
     * @param view
     */
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
