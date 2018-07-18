package edu.byui.fore.fore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Course_Selection extends AppCompatActivity {
    private List<Course> courseList;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course__selection);

        courseList = (ArrayList<Course>)getIntent().getSerializableExtra("Courses");
        List<String> courseNamesList = new ArrayList<>();


        for (Course course : courseList){
            courseNamesList.add(course.getName());
        }

        Spinner s = findViewById(R.id.courseSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, courseNamesList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);

        mTextView = findViewById(R.id.text);

    }

    //If the user doesn't want to track their stats and just wants to temporarily store their score
    //for one game, they can choose the emptyCourse
    public void emptyCourse(View v){
        Course emptyCourse = new Course();

        Intent intent = new Intent(this, CourseConfirmation.class);
        intent.putExtra("Course", emptyCourse);
        intent.putExtra("Courses", (Serializable)courseList);
        Integer test = 0;
        intent.putExtra("Hole", test);
        startActivity(intent);
    }

    //This method will send off the course selected in the spinner with the type selected in
    //the radio group
    public void confirmCourse(View v){
        Spinner s = findViewById(R.id.courseSpinner);
        String name = s.getSelectedItem().toString();

        Course course2play = new Course();

        RadioGroup radioGroup = findViewById(R.id.courseRG);

        int selectedID = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = radioGroup.findViewById(selectedID);
        String selectedText =   radioButton.getText().toString();


        //This if/else if statement determines what the game type will be
        GameTypes type = GameTypes.FULL_18;
        if (selectedText.equals("Front 9")){
            type = GameTypes.FRONT_9;
        }
        else if (selectedText.equals("Back 9")){
            type = GameTypes.BACK_9;
        }

        //This for loop loops through our courseList to determine which course is selected based
        //on the text selected in the spinner
        for (Course course : courseList){
            if(name.equals(course.getName())){
                course2play = course;
            }
        }

        course2play.setCurrentGame(new Game());
        course2play.getCurrentGame().setType(type);
        Intent intent = new Intent(this, CourseConfirmation.class);
        intent.putExtra("Course", course2play);
        intent.putExtra("Courses", (Serializable)courseList);
        intent.putExtra("Hole", Integer.valueOf(0));
        startActivity(intent);
    }
}
