package edu.byui.fore.fore;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AddCourseActivity extends AppCompatActivity {
    private List<Course> courses;
    private Course newCourse;
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);
        TableLayout tableLayout = findViewById(R.id.tLayoutShrink);
        tableLayout.setColumnShrinkable(1, true);

        courses = (ArrayList<Course>) getIntent().getSerializableExtra("Courses");
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void submit(View view) {
        //We initialize this array so that we can easily loop through each EditText view and gather the data
        //entered in.
        int[] ids = new int[]{R.id.hole1par, R.id.hole2par, R.id.hole3par, R.id.hole4par, R.id.hole5par,
                R.id.hole6par, R.id.hole7par, R.id.hole8par, R.id.hole9par, R.id.hole10par,
                R.id.hole11par, R.id.hole12par, R.id.hole13par, R.id.hole14par, R.id.hole15par,
                R.id.hole16par, R.id.hole17par, R.id.hole18par};

        //This list is where we will store the pars in as we loop through EditText views and will be
        //used to call the constructor of our new Course object.
        List<Integer> pars = new ArrayList<>(18);

        //This loop visits each EditText view and gathers the data from the view and stores it in our
        //list. The if/else if statements are input validation to ensure that a par is given for each hole
        int i = 0;
        for (int holeId : ids) {
            EditText et = findViewById(holeId);
            String numString = et.getText().toString();
            if (numString.length() > 0) {
                et.setBackgroundColor(Color.TRANSPARENT);
                Integer par = Integer.parseInt(numString);
                pars.add(i, par);
            } else if (numString.length() <= 0) {
                et.setBackgroundColor(Color.RED);
                return;
            }
            i += 1;
        }


        newCourse = new Course(pars);
        newCourse.setName(((EditText) findViewById(R.id.acCourseName)).getText().toString());

        //This block of code ensures that we don't add the same course twice.
        Boolean addCourseFlag = true;
        for (Course c : courses) {
            if (c.equals(newCourse)) {
                c = newCourse;
                addCourseFlag = false;
            }
        }

        if (addCourseFlag) {
            courses.add(newCourse);
        }

        Toast.makeText(this, newCourse.longitude.toString() + "-" + newCourse.latitude.toString(), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, Course_Selection.class);
        intent.putExtra("Courses", (Serializable) courses);
        startActivity(intent);
    }
}
