package com.example.gymlog.activities;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gymlog.R;

public class ChooseWorkoutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUi();
        for (int i=0; i<20; i++)
            makeText();

    }

    private void setUi() {
        setContentView(R.layout.activity_choose_workout);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }

    private void makeText() {
        // Make some text
        TextView text = new TextView(this);
        text.setText("asdf");
        // Set margins on the text
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(10, 10, 10, 10);
        text.setLayoutParams(params);
        // Add text to parent layout
        LinearLayout parent = (LinearLayout) findViewById(R.id.recents_layout);
        parent.addView(text);
    }

    private void addCard(int parentId) {
        // Do all the same stuff as above, but with cards?
    }
}
