package edu.byui.fore.fore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class strokeCounter_activity extends AppCompatActivity {
    private Integer strokes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stroke_counter);
    }

    public void buttonClick(View view){
        strokes++;

        TextView textView = (TextView) findViewById(R.id.strokes_display);

        textView.setText(strokes.toString());
    }

    public void decrementStrokes(View view){
        strokes--;

        TextView textView = (TextView) findViewById(R.id.strokes_display);

        textView.setText(strokes.toString());
    }
    public void resetStrokes(View view){
        strokes = 0;

        TextView textView = (TextView) findViewById(R.id.strokes_display);

        textView.setText(strokes.toString());
    }
    public void submit(View view){

    }
}
