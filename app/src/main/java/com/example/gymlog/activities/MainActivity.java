package com.example.gymlog.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.gymlog.R;
import com.example.gymlog.db.Repository;
import com.example.gymlog.db.entities.WorkoutActivityEntity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Repository db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new Repository(getApplicationContext());
        db.insertActivity("herp", 5, 10);
        db.insertActivity("asdf", 50, 100);
        db.insertActivity("pooping", 10000, 1);
        List<WorkoutActivityEntity> acts = db.getAllActivities();
//        db.db.getOpenHelper().close();
        Log.d("DATABASE", "number of entries: " + acts.size());
        Log.d("DATABASE", acts.toString());
    }

    public void displayChooseWorkoutActivity(View view) {
        Intent intent = new Intent(this, ChooseWorkoutActivity.class);
        startActivity(intent);
    }
}
