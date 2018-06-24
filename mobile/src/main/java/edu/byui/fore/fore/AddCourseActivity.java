package edu.byui.fore.fore;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AddCourseActivity extends AppCompatActivity {
    private List<Course> courses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);
        courses = (List<Course>)getIntent().getSerializableExtra("Courses");
    }

    public void submit(View view){
        int[] ids = new int[]{R.id.hole1par,R.id.hole2par,R.id.hole3par, R.id.hole4par, R.id.hole5par,
                              R.id.hole6par, R.id.hole7par, R.id.hole8par, R.id.hole9par, R.id.hole10par,
                              R.id.hole11par, R.id.hole12par, R.id.hole13par,R.id.hole14par, R.id.hole15par,
                              R.id.hole16par, R.id.hole17par, R.id.hole18par};
        List<Integer>  pars = new ArrayList<>(18);
        int i = 0;
        for (int holeId : ids){
            String numString = ((EditText)findViewById(holeId)).getText().toString();
            pars.add(i,Integer.parseInt(numString));
        }
        Course newCourse = new Course(pars);
        newCourse.setName(((EditText) findViewById(R.id.acCourseName)).toString());
        courses.add(newCourse);
        Intent intent = new Intent(this, Course_Selection.class);
        intent.putExtra("Courses", (Serializable)courses);
        startActivity(intent);
    }

}
