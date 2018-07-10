package edu.byui.fore.fore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.Touch;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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

        int[] ids = new int[]{R.id.game1score, R.id.game2score, R.id.game3score, R.id.game4score,
                              R.id.game5score, R.id.game6score, R.id.game7score, R.id.game8score,
                              R.id.game9score, R.id.game10score};
        int i = 0;
        EditText editText;
        for (Game game: course.getGames()){
            editText = findViewById(ids[i]);
            editText.setText(game.getTotal());
            editText.setVisibility(View.VISIBLE);
            i++;
        }

        Toast.makeText(this,course.getCurrentGame().getTime().toString(), Toast.LENGTH_SHORT);
    }

    public void finishGame(View view){
        course.addCurrentGame();
        ArrayList<Course> courseList = (ArrayList)getIntent().getSerializableExtra("Courses");
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
            e.printStackTrace();
        }

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
