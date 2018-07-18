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
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Course> courseList;
    public static final String FILENAME = "courses.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize the jsonStr to null
        String jsonStr ="";
        try {
            //Try to open the file
            FileReader fileReader = new FileReader(this.getFilesDir().getPath() + "/" + FILENAME);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //The file will always be a single line, so we read that line in and add it to the jsonString
            jsonStr  += bufferedReader.readLine();
            
        } catch (FileNotFoundException e) {
            //If there isn't a file, it's not the end of the world so we'll just log it.
           Log.e("ERROR", "No file found");


        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();

        //Using a TypeToken is the only way to serialize a list of Objects
        //the fromJson method needs to know what type of object to extract from
        //the json string. The TypeToken contains that information
        Type listType = new TypeToken<ArrayList<Course>>(){}.getType();
        courseList = (List<Course>)gson.fromJson(jsonStr, listType);

        //If there was nothing in the file or it didn't exist, we will just start with no courses
        if(jsonStr.isEmpty()){

            courseList = new ArrayList<>();
        }
    }

    //If the user chooses to select from an already existing course, we will go straight to the
    //course selection activity
    public void selectCourse(View view){
        Intent intent = new Intent(this, Course_Selection.class);
        intent.putExtra("Courses", (Serializable)courseList);
        startActivity(intent);
    }

    //If the user chooses to add a new course, we will go first to the add course activity
    public void addCourse(View view){
        Intent intent = new Intent(this, AddCourseActivity.class);
        intent.putExtra("Courses", (Serializable)courseList);
        startActivity(intent);
    }

}
