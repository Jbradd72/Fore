package edu.byui.fore.fore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Course> courseList;
    public static final String FILENAME = "courses.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String jsonStr ="";
        try {
            FileReader fileReader = new FileReader(FILENAME);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.read() != -1){
                    jsonStr  += bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
           // Log.e();

        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Course>>(){}.getType();
        courseList = gson.fromJson(jsonStr, listType);
    }

    public void selectCourse(View view){
        Intent intent = new Intent(this, Course_Selection.class);
        intent.putExtra("Courses", (Serializable)courseList);
        startActivity(intent);
    }

    public void addCourse(View view){
        Intent intent = new Intent(this, AddCourseActivity.class);
        intent.putExtra("Courses", (Serializable)courseList);
        startActivity(intent);
    }

}
