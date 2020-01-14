package com.example.gymlog.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.gymlog.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void displayChooseWorkoutActivity(View view) {
        Intent intent = new Intent(this, ChooseWorkoutActivity.class);
        startActivity(intent);
    }
}
