package edu.byui.fore.fore;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.TextView;

public class activity_courseSelect extends WearableActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_select);

        mTextView = findViewById(R.id.text);
    }
    public void confirmCourse(View v){
        Intent tutorialPage = new Intent(this, CourseConfirmation.class);
        startActivity(tutorialPage);
    }
}
