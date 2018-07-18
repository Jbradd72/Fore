package edu.byui.fore.fore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This activity contains the game summary at the end of a game.
 */
public class GameSummaryActivity extends AppCompatActivity {
    public static final String FILENAME = "courses.txt";
    Course course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_summary);

        course = (Course) getIntent().getSerializableExtra("Course");

        TextView textView = findViewById(R.id.gsCourseName);
        textView.setText(course.getName());

        textView = findViewById(R.id.currentScore);
        textView.setText(course.getCurrentGame().getTotal().toString());


        //We initialize the ids array with all of the ids we want to loop through later on
        int[] ids = new int[]{R.id.game1score, R.id.game2score, R.id.game3score, R.id.game4score,
                              R.id.game5score, R.id.game6score, R.id.game7score, R.id.game8score,
                              R.id.game9score, R.id.game10score};
        int i = 0;

        //Here we loop through all of the games played in the course and display the scores
        for (Game game: course.getGames()){
            textView = findViewById(ids[i]);
            textView.setText(game.getTotal().toString());
            textView.setVisibility(View.VISIBLE);
            i++;
        }

        //We show a toast here telling the user how long it took to finish the game
        Toast.makeText(this, course.getCurrentGame().getTime(),Toast.LENGTH_SHORT).show();
    }

    /**
     * Takes the completed game and adds it to the current course, serializing the data into a JSON
     * string. it then writes to a local file.
     * @param view
     */
    public void finishGame(View view){
        //Add the game just played to the courses list of games
        course.addCurrentGame();

        ArrayList<Course> courseList = (ArrayList)getIntent().getSerializableExtra("Courses");

        //This for loop determines if the current game was played on a course that was already
        //in our list of courses prior to the game just played. If it is, we override it, if not,
        //we simply add it to the end of the courseList
        Boolean newCourse = true;
        for (int i = 0; i < courseList.size(); i++){
            if (courseList.get(i).getName().equals(course.getName())){
                courseList.set(i, course);
                newCourse = false;
            }
        }
        if (newCourse){
            courseList.add(course);
        }

        Gson gson = new Gson();
        String json = gson.toJson(courseList);


        try {
            FileWriter fileWriter = new FileWriter(this.getFilesDir().getPath() + "/" + FILENAME,false);
            fileWriter.write(json);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            Log.e("GAME_SUMMARY_ACTIVITY", "IOException");
            e.printStackTrace();
        }

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
