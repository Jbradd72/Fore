package edu.byui.fore.fore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Course_Selection extends AppCompatActivity {
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course__selection);
        mTextView = findViewById(R.id.text);
    }

    public void confirmCourse(View v){
        Intent tutorialPage = new Intent(this, CourseConfirmation.class);
        startActivity(tutorialPage);
    }
}
