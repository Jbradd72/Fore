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

    public void emptyCourse(View v){
        Course emptyCourse = new Course();

        Intent intent = new Intent(this, CourseConfirmation.class);
        intent.putExtra("Course", emptyCourse);
        intent.putExtra("Courses", (Serializable)courseList);
        Integer test = 0;
        intent.putExtra("Hole", test);
        startActivity(intent);
    }

    public void confirmCourse(View v){
        Spinner s = findViewById(R.id.courseSpinner);
        String name = s.getSelectedItem().toString();

        Course course2play = new Course();

        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.courseRG);

        int selectedID = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) radioGroup.findViewById(selectedID);
        String selectedtext =   radioButton.getText().toString();


        GameTypes type = GameTypes.FULL_18;
        if (selectedtext.equals("Front 9")){
            type = GameTypes.FRONT_9;
            Toast.makeText(this, "Front 9 Selected", Toast.LENGTH_SHORT).show();
        }
        else if (selectedtext.equals("Back 9")){
            type = GameTypes.BACK_9;

        }


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
