package edu.byui.fore.fore;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

 /**
 * This activity is used to add a course to the course list. It takes in a par value for each
  *  hole in a given course. The user then submits this form an is redirected to the course
  *  select page.
 */
public class AddCourseActivity extends AppCompatActivity {
    private List<Course> courses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);
        TableLayout tableLayout = findViewById(R.id.tLayoutShrink);
        tableLayout.setColumnShrinkable(1, true);
        courses = (ArrayList<Course>)getIntent().getSerializableExtra("Courses");
    }

     /**
      * Submits the inputted par values and adds them to the course.
      * @param view the view that the user submitted the pars to
      */
    public void submit(View view){
        int[] ids = new int[]{R.id.hole1par,R.id.hole2par,R.id.hole3par, R.id.hole4par, R.id.hole5par,
                              R.id.hole6par, R.id.hole7par, R.id.hole8par, R.id.hole9par, R.id.hole10par,
                              R.id.hole11par, R.id.hole12par, R.id.hole13par,R.id.hole14par, R.id.hole15par,
                              R.id.hole16par, R.id.hole17par, R.id.hole18par};

        List<Integer>  pars = new ArrayList<>(18);
        int i = 0;
        for (int holeId : ids){
            EditText et = findViewById(holeId);
            String numString = et.getText().toString();
            if (numString.length() > 0) {
                et.setBackgroundColor(Color.TRANSPARENT);
                Integer par = Integer.parseInt(numString);
                pars.add(i, par);
            }
            else if (numString.length() <= 0){
                et.setBackgroundColor(Color.RED);
                return;
            }
            i += 1;
        }
        Course newCourse = new Course(pars);
        newCourse.setName(((EditText) findViewById(R.id.acCourseName)).getText().toString());

        Boolean addCourseFlag = true;

        for (Course c : courses){
            if(c.equals(newCourse)){
                c = newCourse;
                addCourseFlag = false;
            }
        }

        if (addCourseFlag){
            courses.add(newCourse);
        }


        Intent intent = new Intent(this, Course_Selection.class);
        intent.putExtra("Courses", (Serializable)courses);
        startActivity(intent);
    }

}
