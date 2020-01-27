package com.example.gymlog.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.gymlog.R;
import com.example.gymlog.db.Repository;
import com.example.gymlog.db.entities.WorkoutActivityEntity;
import com.example.gymlog.logic.Workout;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Repository db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Testing database
        db = new Repository(getApplicationContext());
        Workout w1 = new Workout();
        db.insertActivity(w1);
        List<WorkoutActivityEntity> w = db.getAllActivities();
        for (int i=0; i<w.size(); i++)
            Log.d("DATABASE", w.get(i).toString());
    }

//    public void displayChooseWorkoutActivity(View view) {
//        Intent intent = new Intent(this, ChooseWorkoutActivity.class);
//        startActivity(intent);
//    }

    // TODO
    public void displayHistoryActivity(View view) {

    }

    // TODO
    public void displayStatisticsActivity(View view) {

    }
}
